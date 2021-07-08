package com.example.myplugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Time:2021/7/7 20:23
 * Author: lidongjie
 * Description:
 */
class MyPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        println("this is MyPlugin")
        project.extensions.create('pluginExtension', PluginExtension)
        project.afterEvaluate {
            println project.pluginExtension.message
        }
    }
}
