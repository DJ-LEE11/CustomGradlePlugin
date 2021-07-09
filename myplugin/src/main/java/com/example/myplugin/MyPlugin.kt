package com.example.myplugin

import com.android.build.gradle.AppPlugin
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.ProjectConfigurationException

/**
 * Time:2021/7/8 21:49
 * Author: lidongjie
 * Description:
 */
class MyPlugin : Plugin<Project> {

    private lateinit var project: Project
    private lateinit var android: BaseExtension

    override fun apply(project: Project) {
        println("this is MyPlugin =====================>")
        this.project = project
        printProjectInfo(project)

        isAppPlugin(project)

        getConfigInfo(project)

        hookTask(project)

        project.afterEvaluate {
            project.tasks.register("MyTask", MyPluginTask::class.java) {

            }
        }

    }

    /**
     * 打印项目信息
     */
    private fun printProjectInfo(project: Project) {
        project.allprojects {
            println("AllProjects name = ${it.name}")
            println("AllProjects path = ${it.path}")
        }
        project.tasks.forEach {
            println("tasks name = ${it.name}")
            println("tasks path=  ${it.path}")
        }
    }

    /**
     * 判断当前插件是否运行在App插件上
     */
    private fun isAppPlugin(project: Project) {
        val appPlugin = project.plugins.hasPlugin(AppPlugin::class.java)
        val libPlugin = project.plugins.hasPlugin(LibraryPlugin::class.java)
        if ((appPlugin) || libPlugin) {
            android = project.extensions.getByName("android") as BaseExtension
        } else {
            throw ProjectConfigurationException(
                "plugin 'com.android.application' or 'com.android.library'  must be apply",
                Throwable()
            )
        }
    }

    /**
     * 获取配置信息
     */
    private fun getConfigInfo(project: Project) {
        val pluginExtension =
            project.extensions.create("pluginExtension", PluginExtension::class.java)
        project.afterEvaluate {
            println(pluginExtension.message)
        }
    }

    /**
     * hook某个任务
     */
    private fun hookTask(project: Project) {
        project.afterEvaluate {
            val mergeDebugAssetsTask = project.tasks.findByName("mergeDebugAssets")
            if (mergeDebugAssetsTask != null) {
                mergeDebugAssetsTask.doFirst {
                    println("MyPlugin hook mergeDebugAssetsTask before")
                }
                mergeDebugAssetsTask.doLast {
                    println("MyPlugin hook mergeDebugAssetsTask after")
                }
            } else {
                println("mergeDebugAssetsTask = null")
            }
        }
    }
}