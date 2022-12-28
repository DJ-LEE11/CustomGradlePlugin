package com.example.asmplugin

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Author: lidongjie01
 * Date: 2022/12/4
 * Desc: 上报类适配器
 *       这个类是拿到要修改的.class文件，然后找到对应要修改的方法
 * SinceVer: 1.0.0
 */
class ReportClassAdapter(private val classVisitor: ClassVisitor) :
    ClassVisitor(Opcodes.ASM7, classVisitor) {

    private lateinit var mClassName: String

    companion object {
        /**
         * 需要处理的方法
         */
        private val TARGET_METHODS = arrayOf("onCreate", "onResume")
    }

    override fun visit(
        version: Int,
        access: Int,
        name: String?,
        signature: String?,
        superName: String?,
        interfaces: Array<out String>?
    ) {
        print("ReportClassAdapter visit -----> started:$name")
        mClassName = name ?: ""
        super.visit(version, access, name, signature, superName, interfaces)
    }

    override fun visitMethod(
        access: Int,
        name: String?,
        descriptor: String?,
        signature: String?,
        exceptions: Array<out String>?
    ): MethodVisitor {
        val mv: MethodVisitor =
            classVisitor.visitMethod(access, name, descriptor, signature, exceptions)
        print("ReportClassAdapter visitMethod mClassName:$mClassName,access:$access,name:$name,desc:$descriptor")
        if (TARGET_METHODS.contains(name)) {
            return ReportMethodAdapter(mv, name ?: "")
        }
        return mv
    }

    override fun visitEnd() {
        print("ReportClassAdapter : visit -----> end")
        super.visitEnd()
    }
}