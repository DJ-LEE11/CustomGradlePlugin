package com.example.asmplugin.test

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Author: lidongjie01
 * Date: 2022/11/30
 * Desc: OnCreateMethod - 这是一个简单实现版本
 * SinceVer: 1.0.0
 */
class ReportTestMethodVisitor(private val visitor: MethodVisitor, private val methodName: String) :
    MethodVisitor(Opcodes.ASM4, visitor) {

    override fun visitCode() {
        super.visitCode()
        //方法执行前插入 Log.i("ReportPlugin-------> $methodName : $getClass()")
        mv.visitLdcInsn("ReportPlugin")
        mv.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        mv.visitInsn(Opcodes.DUP)
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false)
        mv.visitLdcInsn("-------> $methodName : ")
        mv.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        mv.visitVarInsn(Opcodes.ALOAD, 0)
        mv.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Object",
            "getClass",
            "()Ljava/lang/Class;",
            false
        )
        mv.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Class",
            "getSimpleName",
            "()Ljava/lang/String;",
            false
        )
        mv.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        mv.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "toString",
            "()Ljava/lang/String;",
            false
        )
        mv.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "android/util/Log",
            "i",
            "(Ljava/lang/String;Ljava/lang/String;)I",
            false
        )
        mv.visitInsn(Opcodes.POP)
    }
}