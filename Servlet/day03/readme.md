### 数据访问对象
- Data Access Object: 数据访问对象，它里面有写访问数据库的代码
- 一个工程中，有多少张列表，基本上就有多少个对应的Dao对象，每一个数据访问对象，只操作一张表的数据
- 也没什么难的，就是组织代码的一种方式呗，易于维护。


### 一个工程有哪些包
- dao包： 里面存放各种DAO，一般情况下，每一张表都要对应一个单独的数据访问对象。
- entity: 里面存放各种实体对象，一张表要对应一个实体对象。
- controller: 里面存放各种Servlet
- utils: 存放各种工具类


### 英雄表增删改查项目步骤
1. 新建一个Maven Web工程
    - 创建Maven工程， 勾选create simple project, 工程类型是 war
    - Genarate Deployment Description Stub
    - 配置TomCat, 工程上右键选择属性, Runtime Target, 勾选Tomcat.
    - 在pom.xml文件中，添加Maven依赖描述
2. 在数据库中准备好一张表
    ```
    USE newdb3;

    CREATE TABLE hero(id INT PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(20),
    type VARCHAR(20),
    gender VARCHAR(5),
    price Int)
    CHARSET=UTF8;

    INSERT INTO hero VALUES(null, "孙悟空", "刺客", "公", 6888);

    SELECT * FROM hero;
    ```
3. 实现添加功能
    1. 在webapp下，新建add.html页面， 页面中准备表单 method="GET" action="AddServlet"
    2. 新建controller包，创建AddServlet, 获取浏览器传递过来的参数
    3. 新建entity包，里面新建一个Hero实体类
    4. 新建dao包，里面新建一个HeroDAO的数据访问对象
    5. 在HeroDAO中实现insert()方法
    6. 在AddServlet的doGet方法中，将获取的参数封装到Hero实体类中，实例化一个HeroDAO数据访问对象，把Hero实体类传给HeroDAO的insert()方法，调用insert()方法，
   
4. 实现查询功能
    1. 新建FindAllServlet
    2. doGet()方法中, 实例化HeroDAO，调用其findAll()方法
    3. 在HeroDAO.java中, 写出findAll()的具体实现。
    4. 将findAll()返回的结果，赋值给一个集合
    5. 通过PrintWriter返回给浏览器一个数据相关页面

