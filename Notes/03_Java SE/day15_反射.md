# 什么是反射？
在 Java 运行时环境中，对于任意一个类都可以知道这个类有哪些属性和方法；对于任意一个对象都可以调用它的任意一个方法。
这种**动态地获取类的信息和调用对象的方法的机制**，就是反射。

# 有什么好处？
- 提高了灵活性。
- 是各种框架运行的基础。

# 缺点?
- 资源开销大小
- 运行慢



# 类对象 Class 类
- Class 类的实例用于表示 JVM 加载的一个类。
- 每个被 JVM 加载的类，有且只有唯一的一个 Class 实例与之对应。
- 通过 Class 实例，我们可以得知其表示的类的一切信息（类名、属性、方法、构造器）
- 并可以进行快速实例化。

## 获取类对象的常用方式
1. **类名.class**
    - 每个类都有一个静态属性 class, 用于获取该类的类对象
    - 例如`String.class`, `Array.class`,`int.class`
    - 优点是简单直接，缺点是硬编码获取。
2. **Class.forName**
    - 通过 Class 的静态方法，指定类的完全限定名，来获取类对象。
    ```java
    Classs cls = Class.forName("java.lang.String");
    String name = cls.getName();
    System.out.println(name);
    ```

3. 通过 **ClassLoader** 类加载器加载

示例：
```java
public class ReflectionDemo {
    public static void main(String[] args) {
        
        // Class clazz = Person.class;
        try {
            // 获取用户输入
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入类的完全限定名：");
            String className = scan.nextLine();
            scan.close();
            // 反射获取类的信息
            Class<?> cls = Class.forName(className);
            String clsName = cls.getName();
            System.out.println("className: " + clsName);
            System.out.println("\nMethods: ");
            List<Method> methods = Arrays.asList(cls.getMethods());
            methods.forEach(
                    m -> {
                        System.out.println(m.getName());
                    }
            );
            System.out.println("\nDeclared Methods:");
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Method method : declaredMethods) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
}

```
控制台输出：
```
请输入类的完全限定名：
reflection.Person
className: reflection.Person

Methods: 
dosome
sayHello
say
say
wait
wait
wait
equals
toString
hashCode
getClass
notify
notifyAll

Declared Methods:
public void reflection.Person.dosome()
public void reflection.Person.sayHello()
public void reflection.Person.say(java.lang.String,int)
public void reflection.Person.say(java.lang.String)

```

### Class 类对象的方法
- `String getName()`: 获取当前类对象所表示的类的名字。
- `Method[] getMethods() throws SecurityException`: 获取所有公有方法。
- `Method[] getDeclaredMethods()`: 获取所有类中定义的方法。

- `Object newInstance()`:调用无参构造器，获取一个实例对象
```java
public class ReflectionDemo2 {
    public static void main(String[] args) {
        
        try {
            
            // 1. 加载类对象
            Class<?> cls = Class.forName("reflect.Person");
            
            // 2. 调用类对象的 newInstance() 方法
            Object obj = cls.newInstance();
            
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
}
```
- `getConstructor(parameterTypes)`: 获取一个指定参数类型的构造器

### Method 对象的方法
- `String getName()`: 得到方法名
- `void invoke(Object obj, Object args...)` 方法调用

### Constructor 中的方法
- `Object newInstance()`:获取一个实例对象
```java
public class ReflectionDemo3 {
    public static void main(String[] args) {
        
        try {
            
            // 1. 获取类对象
            Class<?> cls = Class.forName("reflection.Student");
            
            // 2. 获取构造器
            Constructor<?> constructor = cls.getConstructor(String.class, int.class);
            
            // 3. 调用构造器的 newInstance 方法
            Object obj = constructor.newInstance("老王", 99);
            
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
}
```
```java
/**
 * 利用反射调用方法
 * @author yuyu
 *
 */
public class RelectionDemo4 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入类名");
        String className = scan.nextLine();
        System.out.println("请输入方法名");
        String methodName = scan.nextLine();
        scan.close();
        // 1. 获取类对象
        Class<?> cls = Class.forName(className);
        // 2. 通过类对象实例化对象
        Object obj = cls.newInstance();
        // 3. 通过类对象获取方法
        Method m = cls.getMethod(methodName);
        // 4. 方法被示例对象调用 invoke
        m.invoke(obj);
    }
}

```
控制台输出：
```
请输入类名
reflection.Student
请输入方法名
sayHello
学生：大家好，我是小明, 我今年9岁

```

```java
import java.lang.reflect.Method;

public class ReflectionDemo5 {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("reflection.Person");
        
        Object o = cls.newInstance();
        
        Method m = cls.getMethod("say", String.class);
        
        m.invoke(o, "哈喽");
        
        Method m2 = cls.getMethod("say", String.class, int.class);
        m2.invoke(o, "李四", 44);
    }
}
```
控制台输出：
```
person:哈喽
person:大家好我是:李四, 我今年44
```


## 利用反射，调用对象的**私有方法**。
需要用到`Method`的`void setAccessiable(true)`:设置可访问性。
```java
public class ReflectionDemo6 {
    public static void main(String[] args) throws Exception {
        Class<?> clas = Class.forName("Person");
        Object o = clas.newInstance();
        Method m = clas.getMethod("dosome");
        m.setAccessible(true);
        m.invoke(o);
    }
}
```
控制台输出：
```
我是Person的私有方法 dosome()!
```
























