package com.example.asmplugin

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.util.Collections

/**
 * Author: lidongjie01
 * Date: 2022/12/4
 * Desc: 上报插件
 * SinceVer: 1.0.0
 */
class AsmPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        print("start 注册Transform =====================>")
        project.extensions.getByType(AppExtension::class.java).apply {
            registerTransform(ReportTransform(project), Collections.EMPTY_LIST)
        }
    }
}

fun print(str: String) {
    println("AsmPlugin $str")
}