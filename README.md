# Spring-all（Spring和Spring Boot源码整合）

这是一个整合了Spring源码和Spring Boot源码的综合项目。相比于独立调试Spring Boot项目【运行到Spring相关的代码，会进入编译好的只读类文件中，我们无法修改源码】但在这个整合项目中，当运行到Spring相关代码时，可以直接进入Spring源码，可以轻松地修改代码和添加注释。

## Tips:

无论是Spring源码还是Spring Boot源码，如果你直接下载官方的源码包，如果不出意外的话，大概率是要出意外的：你会遇到很多奇奇怪怪的、各种各样的编译问题，所以：

- 如果你不想被【BUILD FAILED】反复折磨，那就请严格按照笔者的教程来准备编译环境。

- 如果你不想被【BUILD FAILED】反复折磨，那就请严格按照笔者的教程来准备编译环境。

- 如果你不想被【BUILD FAILED】反复折磨，那就请严格按照笔者的教程来准备编译环境。

## 编译步骤

### 环境准备

本文档提到的所有软件安装包地址：百度云

本教材不会详细介绍某个软件的安装，因为能到研究spring源码地步的你肯定可以自己解决ヽ(￣▽￣)ﾉ

1. `JDK`环境： `JDK 11`  必须的，8和17会有【缺失】【已过时】【待删除】等错误，会编译失败！
2. `gradle`环境：`gradle-7.5.1` 注意配置好`GRADLE_HOME`和`GRADLE_USER_HOME`环境变量和`init.d`中的初始化文件，具体操作请自行搜索。
3. `maven`环境：`maven-3.6.1` 是的，`gradle`项目依然需要maven环境，注意配置好`M2_HOME`环境变量、`setting.xml`文件

JDK和Maven环境好说，大部分开发人员应该都很熟悉，主要是gradle：安装包我已经提供，找个地方解压就算安装了，找个教程配一下环境变量，再把我给的init.gradle文件放进init.d文件就OK了，后续也不需要我们自己执行什么命令，都在idea中操作。

### 开始编译

1. clone项目

2. 用idea open 本项目，打开后会自动加载本项目，加载结果我们先不管，我们还需要自己配置一些地方。

3. 检查项目SDK设置和gradle设置，具体如图。


![image-20240607224145152](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20240607224145152.png)

![image-20240607224200582](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20240607224200582.png)

![image-20240607224608108](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20240607224608108.png)

4. 设置build参数，跳过单元测试。如此成熟的框架，我们完全没有必要再去执行单元测试。（不跳过会build失败！）

![image-20240607225027660](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20240607225027660.png)

![image-20240607225050288](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20240607225050288.png)

5. 好了，双击build，如果不出意外的话，就能够正常BUILD SUCCESSFUL了。
