package com.example.myplugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Time:2021/7/9 15:05
 * Author: lidongjie
 * Description: 自定义一个任务
 */
open class MyPluginTask : DefaultTask() {

    private var mPluginExtension: PluginExtension? = null

    init {
        group = "my task Group"
        description = "自定义任务"
        mPluginExtension = project.extensions.findByType(PluginExtension::class.java)
    }

    @TaskAction
    fun doSomeThink() {
        println("开始执行自定义任务======》")
        getExtensionInfo()
    }

    /**
     * 获取扩展属性
     */
    private fun getExtensionInfo() {
        if (mPluginExtension != null) {
            println("获取扩展属性成功 msg = ${mPluginExtension?.message}")
        } else {
            println("获取扩展属性失败 mPluginExtension = null")
        }
    }

}