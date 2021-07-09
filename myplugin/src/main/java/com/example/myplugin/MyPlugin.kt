package com.example.myplugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Time:2021/7/8 21:49
 * Author: lidongjie
 * Description:
 */
class MyPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        println("this is MyPlugin")
        val pluginExtension =
            project.extensions.create("pluginExtension", PluginExtension::class.java)
        project.afterEvaluate {
            println(pluginExtension.message)
        }
    }
}