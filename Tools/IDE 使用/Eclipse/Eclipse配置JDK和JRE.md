# 下载 JDK

1. 下载一个JDK8，推荐从Oracle官方下载。
2. 
```
	Project -> Properties:
	Java Build Path: Libraries : Add Library ->
	JRE System Library -> Installed JREs -> Add  -> Standard VM -> JDK 的安装目录 -> Finish
	然后 选择 jdk1.8.0_251
	然后 把jdk1.7的删除 Apply
```

# 系统配置

## 配置JAVA环境变量
用vim打开主目录隐藏的配置文件：
```
vim ~/.bash_profile
```

添加`JAVA_HOME`,`JRE_HOME`,`CLASSPATH`, 最后export path.
```
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-13.0.2.jdk/Contents/Home
export JRE_HOME=$JAVA_HOME/jre
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export PATH=$JAVA_HOME/bin:$PATH:
```
#### 应用并生效
```
source ~/.bash_profile
```
#### 查看版本
```
java -version
```
# Eclipse 配置
- 偏好设置 -> Java -> Compiler -> Complier Compliance Level 选择 1.8.
- 偏好设置 -> Java -> Install JREs : 选择 Java SE 8.
