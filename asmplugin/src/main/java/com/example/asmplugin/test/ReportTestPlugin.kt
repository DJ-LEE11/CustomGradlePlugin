package com.example.asmplugin.test

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Author: lidongjie01
 * Date: 2022/11/29
 * Desc: 上报插件 - 这是一个简单实现版本
 * SinceVer: 1.0.0
 */
class ReportTestPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.extensions.getByType(AppExtension::class.java).apply {
            // 注册Transform
            registerTransform(ReportTestTransform())
        }
    }
}