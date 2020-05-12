# Mac 安装配置maven

## 安装
1. [官网下载](http://maven.apache.org/download.cgi)Binary tar.gz文件
2. 解压到/User/yuyu/Downloads/下

## 终端配置
```
cd Downloads/
mv apache-maven-3.6.2 ../Applications
cd /Users/yuyu
ls -a
open -e .bash_profile
```
在`.bash_profile`中添加两行代码：
```
export M2_HOME=/Applications/apache-maven-3.6.2
export PATH=$PATH:$M2_HOME/bin
```
回到终端
```

在终端输入`mvn -v`测试。

# Eclipse配置
```
Preferences -> Maven>User Settings

1. Installations -> Add -> 选择你下载的maven

2. Global Settings 和 User Settings, 选择 maven安装路径/conf/settings.xml
```


## 检查
```
Window -> Show View -> other -> Maven Repository

可以查看到Local Repository和Global Repository
```

## 新建Maven工程
```
New -> Maven Project

pom.xml不报错就行
```
