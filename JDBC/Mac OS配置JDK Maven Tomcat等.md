# Mac OS 配置Maven


## 安装Java SE JDK

我之前自己安装了一个JRE v12.先把这个删了。
打开终端，复制粘贴
```
cd /Library/Java/JavaVirtualMachines/
ls
sudo rm -rf jdk-12.0.1.jdk/
```
回车完成。

### 下载并安装JDK

1. 官网下载`jdk-13.0.2_osx-x64_bin.dmg`

2. `⌘⇧4, space`,截屏发说说`新的一天，从安装jdk开始……`.

3. 终端查看Java安装位置
```
which java
# 输出/usr/bin/java
```

### 配置JAVA环境变量
用vim打开主目录隐藏的配置文件：
```
vim ~/.bash_profile
```
`i`进入编辑模式，
添加`JAVA_HOME`,`JRE_HOME`,`CLASSPATH`, 最后export path.
```
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-13.0.2.jdk/Contents/Home
export JRE_HOME=$JAVA_HOME/jre
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar

export PATH=$JAVA_HOME/bin:$PATH:
```
`SHIFT + ZZ`保存退出。
#### 应用并生效
```
source ~/.bash_profile
```
#### 查看版本
```
java -version
```
#### 查看配置路径
```
echo $JAVA_HOME
```


## 安装和配置Maven

### 1. [官网下载](http://maven.apache.org/download.cgi),选择  `apache-maven-3.6.3-bin.tar.gz`.

### 2. 主目录创建Java路径，用于存放Java相关工具，使用wget远程下载Maven并解压到这个文件夹
```
mkdir ~/java
cd ~/java
cd ~/Downloads
mv apache-maven-3.6.3-bin.tar.gz ~/java/
tar zxvf apache-maven-3.6.3-bin.tar.gz
```
#### 这些都是tar的参数。.tar.gz是一个压缩包，.tar只是打包而没有压缩，注意这点。
- z：通过gzip支持压缩或解压缩。还有其他的压缩或解压缩方式，比如j表示bzip2的方式。
- x：解压缩。c是压缩。 
- v：在压缩或解压缩过程中显示正在处理的文件名
- f：f后面必须跟上要处理的文件名。也就是说你不能写成这样 tar -zxfv zhcon-0.2.5.tar.gz 
+ z代表gzip的压缩包；x代表解压；v代表显示过程信息；f代表后面接的是文件.

### 3. 配置Maven环境变量
```
vim ~/.bash_profile
# 添加MAVEN_HOME, M2_HOME, PATH
export MAVEN_HOME=/Users/yuyu/java/apache-maven-3.6.3
export M2_HOME=$MAVEN_HOME
export PATH=$PATH:$MAVEN_HOME/bin
```
应用生效：
```
source ~/.bash_profile
或
. ~/.bash_profile
```
### 4. 查看Maven版本
```
mvn -v
```
### 5. 查看安装目录
```
echo $M2_HOME
```

***哈哈哈，终于成功啦***

### 6.更改国内镜像
1. 找到Maven安装目录下的`settings.xml`
```
vim /usr/java/apache-maven-3.6.3/conf/settings.xml
```
2. 全部替换
```
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <localRepository/>
  <interactiveMode/>
  <usePluginRegistry/>
  <offline/>
  <pluginGroups/>
  <servers/>
  <mirrors>
    <mirror>
     <id>aliyunmaven</id>
     <mirrorOf>*</mirrorOf>
     <name>阿里云公共仓库</name>
     <url>https://maven.aliyun.com/repository/public</url>
    </mirror>
     <mirror>
     <id>aliyunmaven</id>
     <mirrorOf>*</mirrorOf>
     <name>阿里云谷歌仓库</name>
     <url>https://maven.aliyun.com/repository/google</url>
    </mirror>
    <mirror>
     <id>aliyunmaven</id>
     <mirrorOf>*</mirrorOf>
     <name>阿里云阿帕奇仓库</name>
     <url>https://maven.aliyun.com/repository/apache-snapshots</url>
    </mirror>
    <mirror>
     <id>aliyunmaven</id>
     <mirrorOf>*</mirrorOf>
     <name>阿里云spring仓库</name>
     <url>https://maven.aliyun.com/repository/spring</url>
    </mirror>
    <mirror>
     <id>aliyunmaven</id>
     <mirrorOf>*</mirrorOf>
     <name>阿里云spring插件仓库</name>
     <url>https://maven.aliyun.com/repository/spring-plugin</url>
    </mirror>
  </mirrors>
  <proxies/>
  <profiles/>
  <activeProfiles/>
</settings>
```


## Intellij IDEA Maven配置
```
Preferences -> Build, Execution, Deployment 
-> Build Tool -> Maven 
-> Maven home directory : 
选择/Users/yuyu/java/apache-maven-3.6.3
User Settings File： 
选择/Users/yuyu/java/apache-maven-3.6.3/conf/settings.xml
```


