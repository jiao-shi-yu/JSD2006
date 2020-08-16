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
在 settings.xml 中添加阿里云：
```xml
<id>nexus-aliyun</id>
<mirrorOf>central</mirrorOf>
<name>Nexus aliyun</name>
<url>http://maven.aliyun.com/nexus/content/groups/public</url>
```
Window -> ShowView -> Maven Repositories
可以看到 aliyun 的镜像仓库。
