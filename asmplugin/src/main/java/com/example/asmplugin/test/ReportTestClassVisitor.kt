package com.example.asmplugin.test

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Author: lidongjie01
 * Date: 2022/11/30
 * Desc: ClassVisitor - 这是一个简单实现版本
 * SinceVer: 1.0.0
 */
class ReportTestClassVisitor(private val classVisitor: ClassVisitor) :
    ClassVisitor(Opcodes.ASM5, classVisitor) {

    companion object {
        private val TARGET_METHODS = arrayOf("onCreate")
    }

    override fun visitMethod(
        access: Int,
        name: String,
        desc: String,
        signature: String?,
        exceptions: Array<String?>?
    ): MethodVisitor {
        val mv: MethodVisitor = classVisitor.visitMethod(access, name, desc, signature, exceptions)
        if (TARGET_METHODS.contains(name)) {
            return ReportTestMethodVisitor(mv, name)
        }
        return mv
    }
}