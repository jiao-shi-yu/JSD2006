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
- Class 类的每一个实例用于表示 JVM 加载的一个类。
- 每个被 JVM 加载的类，有且只有唯一的一个 Class 实例与之对应。
- 通过 Class 实例，我们可以得知其表示的类的一切信息（类名、属性、方法、构造器）
- 并可以进行快速实例化。

## 获取类对象的常用方式
1. **类名.class**
    - 每个类都有一个静态属性 class, 用于获取该类的类对象
2. **Class.forName**
    - 通过 Class 的静态方法，来获取指定的类的类对象。
3. 通过 ClassLoader 类加载器加载

示例：
```java
public class ReflectionDemo {
    public static void main(String[] args) {
        // Class clazz = Person.class;
        try {
            Class cls = Class.forName("reflection.Person");
            List<Method> methods = Arrays.asList(cls.getMethods());
            methods.forEach(
                    m -> {
                        System.out.println(m.getName());
                    }
            );
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
}
```
控制台输出：
```
sayHello
sayHi
wait
wait
wait
equals
toString
hashCode
getClass
notify
notifyAll
```

## Class 类对象的方法
- `String getName()`: 获取当前类对象所表示的类的名字。
- `Method[] getMethods() throws SecurityException`: 获取当前类对象所代表的类的所有方法组成的一个数组。
- `Method[] getDeclaredMethods()`: 获取当前类对象所代表的的类中，所有声明的方法构成的数组。

### Method 对象的方法
- `String getName()`:返回方法名


































