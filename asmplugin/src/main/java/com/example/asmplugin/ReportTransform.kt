package com.example.asmplugin

import com.example.asmplugin.basetransfrom.BaseTransform
import com.example.asmplugin.basetransfrom.RunVariant
import com.example.asmplugin.basetransfrom.asm.BaseModify
import org.gradle.api.Project

/**
 * Author: lidongjie01
 * Date: 2022/12/4
 * Desc: 上报Transform，
 *       注意，这里继承了BaseTransform，
 *       这个BaseTransform内部实现了增量编译、多线程处理、transform处理等通用代码，
 *       子类只需要关注运行的时机、修改的实现类即可
 * SinceVer: 1.0.0
 */
class ReportTransform(private val project: Project) : BaseTransform(project) {

    override fun getBaseModify(): BaseModify {
        return ReportModify()
    }

    override fun getRunVariant(): RunVariant {
        return RunVariant.ALWAYS
    }
}