# 1.SpringBoot框架的作用
SpringBoot框架是一个已经完成了绝大部分配置的SpringMVC框架。
还能更简单的整合其他框架一起使用。

SpringBoot框架的核心思想是"约定大于配置":
框架已经完成了相关配置，开发人员只需要按照相关标准使用即可。


# 2.创建SpringBoot项目
创建SpringBoot项目，与创建传统项目并不太相同：
1. 将SpringBoot作为父级项目，直接创建子集的项目；
2. 在开发工具中直接创建:
    - 如果使用的是Eclipse, 需要安装`Spring Tools`插件:
        ```
        Eclipse -> Help -> Eclipse Marketplace:
        search 'SpringBot', choose 'SpringBoot'
        ```
    - 
3. 从[Spring Initializr](https://start.spring.io/)开始项目.
    ![Spring-initialzr.png]
    - 点击Genarate, 生成项目, 会自动下载。
    - 文件解压，移动到Eclipse的Workspace.

# 2. Import Exist Maven Project
- Maven: Update Project -> Force update;