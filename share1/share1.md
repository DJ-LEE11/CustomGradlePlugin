### Drawable优化

## 一、背景

1、在迭代的过程中，经常会遇到区别仅仅是一个背景颜色和圆角的Drawable，
这类的文件命名也是很难统一，从而难以达到复用的效果，
渐渐的会导致Drawable文件的爆炸式增长，继而增大apk的体积。（统计一共有多少个？）

2、Drawable的解析过程会有少量的IO操作，对性能有略微影响。
homepage：56、baseLive：28、entShowLive：54、live：95、personal：63、pk：16

## 二、自定义View方案

1、自定义View
这种自定义的控件不太灵活，归根到底是一个自定义的button，如果我想改造项目的话就得去替换原有的button或者textView

## 三、动态new Drawable文件

通过xml解析流程，xml也只是根据具体的标签直接new出来对应的是类，
然后再直接设置具体的参数， 如此一来，我们完全可以做到，自己创建具体的对象，
然后设置参数，这样就避免了xml解析这一步


## 四、方案对比

优点：
1、避免xml解析流程
2、复用这些代码
3、 比xml管理方便

缺点：
1、没有预览效果


文章：
https://juejin.cn/post/6953472037012635655
https://mp.weixin.qq.com/s/qxMoI7UTw3WtiRR6oIDGKA
https://juejin.cn/post/7068462054213943304
https://juejin.cn/post/7067333550344781837
https://mp.weixin.qq.com/s/yJM64wm07S3dqdvMvtaHcA
https://mp.weixin.qq.com/s?__biz=MzAxMTI4MTkwNQ==&mid=2650826297&idx=1&sn=f32df9278c87211885f8cd3eb6b20339&chksm=80b7b2a7b7c03bb11deb595ae6340e40483e829997f3dc5e936031fed0da6f5c82adfcb15a54&scene=21#wechat_redirect
https://mp.weixin.qq.com/s/lVUnHbQFCNrCZbaDMoLAcw
https://juejin.cn/post/7054466262889398280


