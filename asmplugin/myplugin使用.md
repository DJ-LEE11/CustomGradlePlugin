1、先执行 Tasks-publishing-publishToMavenLocal 任务，执行完成后会本地.m2仓库生成对应的插件

![](asm1.png)

![](asm2.png)

2、根目录设置 ext.is_apply_asm_plugin = true 

![](asm3.png)

3、build apk 可以在构建日志看到 AsmPlugin 插件的相关日志 

![](asm4.png)

4、安装完apk，打开应用，可以看到相关的插入日志

![](asm5.png)