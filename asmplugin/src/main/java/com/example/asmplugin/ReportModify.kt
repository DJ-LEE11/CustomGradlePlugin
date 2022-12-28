package com.example.asmplugin

import com.example.asmplugin.basetransfrom.asm.BaseModify
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.ClassWriter

/**
 * Author: lidongjie01
 * Date: 2022/12/4
 * Desc: ReportModify修改类
 *       注意，这里继承了BaseModify，
 *       BaseModify内部进行.class相关的处理
 *       子类只需要告诉需要修改的class类，和class类修改的适配器
 * SinceVer: 1.0.0
 */
class ReportModify : BaseModify() {

    companion object {
        /**
         * 需要处理的class
         */
        private const val TARGET_CLASS_PATH = "androidx.fragment.app.FragmentActivity"
    }

    override fun isModifyClass(fullQualifiedClassName: String?): Boolean {
        val superResult = super.isModifyClass(fullQualifiedClassName)
        val isTarget = fullQualifiedClassName?.startsWith(TARGET_CLASS_PATH) ?: false
        return superResult && isTarget
    }

    override fun wrapClassWriter(classWriter: ClassWriter): ClassVisitor {
        return ReportClassAdapter(classWriter)
    }
}