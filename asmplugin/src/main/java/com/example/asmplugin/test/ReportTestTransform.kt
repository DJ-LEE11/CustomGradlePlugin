package com.example.asmplugin.test

import com.android.build.api.transform.DirectoryInput
import com.android.build.api.transform.Format
import com.android.build.api.transform.JarInput
import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformInvocation
import com.android.build.api.transform.TransformOutputProvider
import com.android.build.gradle.internal.pipeline.TransformManager
import org.apache.commons.codec.digest.DigestUtils
import org.apache.commons.io.FileUtils
import org.apache.commons.io.IOUtils
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import java.io.File
import java.io.FileOutputStream
import java.util.jar.JarFile
import java.util.jar.JarOutputStream
import java.util.zip.ZipEntry

/**
 * Author: lidongjie01
 * Date: 2022/12/29
 * Desc: Transform实现  - 这是一个简单实现版本
 * SinceVer: 1.0.0
 */
class ReportTestTransform : Transform() {

    override fun getName(): String {
        return "ReportTransform"
    }

    override fun getInputTypes(): MutableSet<QualifiedContent.ContentType> {
        return TransformManager.CONTENT_CLASS
    }

    override fun getScopes(): MutableSet<in QualifiedContent.Scope> {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    override fun isIncremental(): Boolean {
        return false
    }

    override fun transform(transformInvocation: TransformInvocation?) {
        transformInvocation?.apply {
            outputProvider.deleteAll()
            inputs.forEach { input ->
                input.directoryInputs.forEach {
                    //对类型为文件夹的input进行遍历
                    handleDirInput(it, outputProvider)
                }
                input.jarInputs.forEach { jar ->
                    //对类型为jar文件的input进行遍历
                    handleJarInput(jar, outputProvider)
                }
            }
        }
    }

    private fun handleDirInput(dirInput: DirectoryInput, outputProvider: TransformOutputProvider) {
        if (dirInput.file.isDirectory) {
            FileUtils.listFiles(dirInput.file, null, true).forEach { file ->
                val name = file.name
                // 过滤要处理.class文件
                if (checkDirClassFile(name)) {
                    val classReader = ClassReader(file.readBytes())
                    val classWriter = ClassWriter(classReader, ClassWriter.COMPUTE_MAXS)
                    // 交给ASM访问对应的class
                    val cv = ReportTestClassVisitor(classWriter)
                    classReader.accept(cv, ClassReader.EXPAND_FRAMES)
                    val code = classWriter.toByteArray()
                    val fos = FileOutputStream(file.parentFile.absolutePath + File.separator + name)
                    fos.write(code)
                    fos.close()
                }
            }
        }
        // 获取output目录
        val dest = outputProvider.getContentLocation(
            dirInput.name,
            dirInput.contentTypes,
            dirInput.scopes,
            Format.DIRECTORY
        )
        // 将input的目录复制到output指定目录
        FileUtils.copyDirectory(dirInput.file, dest)
    }

    private fun checkDirClassFile(name: String): Boolean {
        return (name.endsWith(".class") && !name.startsWith("R\$") && "R.class" != name
                && "BuildConfig.class" != name && "androidx/fragment/app/Fragment.class" == name)
    }

    private fun handleJarInput(jarInput: JarInput, outputProvider: TransformOutputProvider) {
        if (jarInput.file.absolutePath.endsWith(".jar")) {
            var jarName = jarInput.name
            val md5Name = DigestUtils.md5Hex(jarInput.file.absolutePath)
            if (jarName.endsWith(".jar")) {
                jarName = jarName.substring(0, jarName.length - 4)
            }
            val jarFile = JarFile(jarInput.file)
            val enumeration = jarFile.entries()
            val tmpFile = File(jarInput.file.parent + File.separator + "classes_temp.jar")
            if (tmpFile.exists()) {
                tmpFile.delete()
            }
            val jarOutputStream = JarOutputStream(FileOutputStream(tmpFile))
            while (enumeration.hasMoreElements()) {
                val jarEntry = enumeration.nextElement()
                val entryName = jarEntry.name
                val zipEntry = ZipEntry(entryName)
                val inputStream = jarFile.getInputStream(jarEntry)
                if (checkJarClassFile(entryName)) {
                    jarOutputStream.putNextEntry(zipEntry)
                    val classReader = ClassReader(IOUtils.toByteArray(inputStream))
                    val classWriter = ClassWriter(classReader, ClassWriter.COMPUTE_MAXS)
                    val cv = ReportTestClassVisitor(classWriter)
                    classReader.accept(cv, ClassReader.EXPAND_FRAMES)
                    val code = classWriter.toByteArray()
                    jarOutputStream.write(code)
                } else {
                    jarOutputStream.putNextEntry(zipEntry)
                    jarOutputStream.write(IOUtils.toByteArray(inputStream))
                }
                jarOutputStream.closeEntry()
            }
            jarOutputStream.close()
            jarFile.close()
            val dest =
                outputProvider.getContentLocation(
                    jarName + md5Name,
                    jarInput.contentTypes,
                    jarInput.scopes,
                    Format.JAR
                )
            FileUtils.copyFile(tmpFile, dest)
            tmpFile.delete()
        }
    }

    private fun checkJarClassFile(name: String): Boolean {
        return (name.endsWith(".class") && !name.startsWith("R\$") && "R.class" != name
                && "BuildConfig.class" != name && "androidx/fragment/app/Fragment.class" == name)
    }
}