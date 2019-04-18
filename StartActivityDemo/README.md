## 正确理解和使用 Activity的4种启动模式

​         Activity的启动模式有4种，分别是standard.singleTop. SingleTask. singleInstance，可以在AndroidMainifest.xml文件中指定每一个Activity的启动模式。一个Android应用一般都会有多个Activity，系统会通过任务栈来管理这些Activity，栈是一种后进先出的集合，当前的Activity就在栈顶，按返回键，栈顶Activity就会退出。Activity启动模式不同，系统通过任务栈管理Activity的方式也会不同，以下将分别介绍。

####1 Standard模式

Standard模式是Android的默认启动模式，你不在配置文件中做任何设置，那么这个Activity就是standard模式，这种模式下，Activity可以有多个实例，每次启动Activity，无论任务栈中是否已经有这个Activity的实例，系统都会创建一个新的Activity实例。

什么时候用standard模式呢？standartd模式是activity的默认模式，大部分情况下，都应该使用这种模式，也就是在配置文件中什么都不用做，当确实有特殊需求时，再考虑其他模式。

####2 SingleTop模式

SingleTop模式和standard模式非常相似，主要区别就是当一个singleTop模式的Activity已经位于任务栈的栈顶，再去启动它时，不会再创建新的实例，不过会调用onNewIntent()函数，如果不位于栈顶，就会创建新的实例，现在把配置文件中FirstActivity的启动模式改为SingleTop，我们的应用只有一个Activity，FirstActivity自然处于任务栈的栈顶。

​         当一个Activity已经在栈顶，但依然有可能启动它，而你又不想产生新的Activity实例，此时就可以用singleTop模式。例如，一个搜索Activity，可以输入搜索内容，也可以产生搜索结果，此时就可以用singleTop模式，不会用户每次搜索都会产生一个实例。

####3 SingleTask模式

​         SingleTask模式的Activity在同一个Task内只有一个实例，如果Activity已经位于栈顶，系统不会创建新的Activity实例，和singleTop模式一样。但Activity已经存在但不位于栈顶时，系统就会把该Activity移到栈顶，并把它上面的activity出栈。 

singleTask模式和前面两种模式的最大区别就是singleTask模式是任务内单例的，所以我们是否设定Activity为singleTask模式，就是看我们activity是否需要单例，例如你的某个Activity

里面有一个列表，如果有多个实例，有可能导致用户看到的列表不一致，有的Activity需要经常启动，如果每次都创建实例，会导致占用资源过多，这些情况都可以使用singleTask模式，但启动singleTask模式的Activity会导致任务栈内它上面的Activity被销毁，有可能会影响用户体验，使用时要注意。

####4 SingleInstance模式

singleInstance模式也是单例的，但和singleTask不同，singleTask只是任务栈内单例，系统里是可以有多个singleTask Activity实例的，而singleInstance Activity在整个系统里只有一个实例，启动一singleInstanceActivity时，系统会创建一个新的任务栈，并且这个任务栈只有他一个Activity。

SingleInstance模式并不常用，如果我们把一个Activity设置为singleInstance模式，你会发现它启动时会慢一些，切换效果不好，影响用户体验。它往往用于多个应用之间，例如一个电视launcher里的Activity，通过遥控器某个键在任何情况可以启动，这个Activity就可以设置为singleInstance模式，当在某应用中按键启动这个Activity，处理完后按返回键，就会回到之前启动它的应用，不影响用户体验。

以上分析了Activity的4种启动模式，将Activity设置为哪种启动模式并没有标准答案，有时候，你可能发现将某个Activity设置为一种启动模式或者另一种启动模式，并没有明显区别，而具体的评判标准就是看哪种模式更满足应用功能，更有利于用户体验。



**备注：Demo地址：**<https://github.com/MinTate/AndroidDemo/tree/master/StartActivityDemo>





