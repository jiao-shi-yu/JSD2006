# 安装 Maven

## 安装和配置Maven

1. [官网下载Maven](http://maven.apache.org/download.cgi),选择  `apache-maven-3.6.3-bin.tar.gz`.
2. 主目录创建 java 路径，将 Maven 解压到当前目录.


# 在 Eclipse 中配置 Maven
1. 添加 Maven
    Preferences -> Maven -> Installations -> Add 你的安装路径 -> 应用并关闭

2. 配置 settings.xml
    Preferences -> Maven -> User Settings -> 安装路径/conf/settings.xml -> 应用并关闭

3.  项目右键 --> Maven --> 更新 Maven 工程。


# 配置阿里云镜像仓库
将 settings.xml 中的内容替换为：
```xml
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
        <id>ali yun</id>
        <name>aliyun maven</name>
        <url>https://maven.aliyun.com/repository/public/</url>
     <id>aliyunmaven</id>
     <mirrorOf>*</mirrorOf>
     <name>阿里云spring插件仓库</name>
     <url>https://maven.aliyun.com/repository/spring-plugin</url>
    </mirror>
</mirrors>
  </mirrors>
  <proxies/>
  <profiles/>
  <activeProfiles/>
</settings>
```
Window -> ShowView -> Maven Repositories
可以看到 aliyun 的镜像仓库。