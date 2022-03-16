### Android前后台切换监听方案

## 一、旧方案

在Application中registerActivityLifecycleCallbacks，通过变量统计然后判断出是前台还是后台。