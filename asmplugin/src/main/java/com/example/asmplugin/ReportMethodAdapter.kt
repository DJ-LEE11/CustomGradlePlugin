package com.example.asmplugin

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Author: lidongjie01
 * Date: 2022/12/4
 * Desc: 方法适配器
 *       这个类是拿到要修改的方法，通过插入字节码，实现无痕日志打印
 * SinceVer: 1.0.0
 */
class ReportMethodAdapter(private val visitor: MethodVisitor, private val methodName: String) :
    MethodVisitor(Opcodes.ASM7, visitor) {

    override fun visitCode() {
        super.visitCode()
        print("ReportMethodAdapter : visitCode methodName$methodName")
        //插入日志
        printLog(methodName)
    }

    private fun printLog(methodName: String) {
        mv.visitLdcInsn("AsmPlugin")
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