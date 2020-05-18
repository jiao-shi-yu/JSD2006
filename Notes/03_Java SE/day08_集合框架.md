

# 集合框架

java.util.Collection 是顶级接口，里面规定了所有集合都应当具备的功能，有两个常用的子接口 List 与 Set.
List 是可重复集。
Set 是不可重复集。


> 集合与泛型相联系，可以先复习一下泛型的知识。


## 集合接口中的抽象方法

- `int size();`: 返回集合中元素的个数

- `boolean isEmpty();`: 判断集合是够为空集。

- `boolean add(E e);`: 将元素添加到集合中，添加成功返回 true; 不成功返回 false.

- `boolean addAll(Collection<? extends E> c);`: 将给定集合的元素添加的集合中。

- `boolean contains(E e);` : 判断集合时候包含指定元素，判断依据是 equals() 方法。

- `boolean containsAll(Collection<?> c)`: 判断当前集合时候包含给定集合的所有元素。

- `boolean remove(Object o);`: 将给定元素从集合中删除。

- `boolean removeAll(Collectioin<?> c);`: 将给定集合中的所有元素，从当前集合中删除。

- `boolean retainAll(Collection<?> c);`: 保留集合 2 中的所有元素，也就是取交集。

- `void clear();`: 清空集合中的元素。

- `Iterator<E> iterator();`: 获取当前集合的迭代器。

```java
package collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<String>();
        System.out.println("size:" + collection.size());
        System.out.println("isEmpty:" + collection.isEmpty());
        collection.add("one");
        System.out.println("collection:" + collection);
        Collection<String> collection2 = new ArrayList<>();
        collection2.add("two");
        collection2.add("three");
        System.out.println("c2:"+collection2);
        collection.addAll(collection2);
        System.out.println("collection:" + collection);
        
        collection.remove("one");
        System.out.println("collection:"+collection);
        
        collection.removeAll(collection2);
        System.out.println("collection:"+collection);
        
        
        
        collection.add("one");
        collection.add("two");
        collection.add("three");
        
        boolean containsOne = collection.contains("one");
        boolean containsAll = collection.containsAll(collection2);
        System.out.println("collection contains \"one\":" + containsOne);
        System.out.println("collection contains All collection2:" + containsAll);
        
        System.out.println("collection: "+collection);
        System.out.println("collection2: "+collection2);
        
        collection.retainAll(collection2);
        System.out.println("collection: "+collection);
        
        collection.clear();
        System.out.println("collection:" + collection);
    }
}
```
控制台输出：
```
size:0
isEmpty:true
collection:[one]
collection2:[two, three]
collection:[one, two, three]
collection:[two, three]
collection:[]
collection contains "one":true
collection contains All collection2:true
collection: [one, two, three]
collection2: [two, three]
collection: [two, three]
collection:[]
```






2. 集合只能存放引用类型元素，并且存放的是元素的引用，对于基本类型，存放的是包装类。
```java

```
3. Java 中只有值传递
```java
package collection;

import java.util.ArrayList;
import java.util.Collection;

public class ReferenceDemo {
    public static void main(String[] args) {
        String str = "hello";
        int a = 1;
        Point p = new Point(1, 2);
        Collection c = new ArrayList();
        c.add(p);
        dosome(a, str, p, c);
        System.out.println("str:" + str);
        System.out.println("a:" + a);
        System.out.println("p:" + p);
        System.out.println("c:" + c);
        
    }

    private static void dosome(int a, String str, Point p, Collection c) {
        str = str + "world";
        a = a + 1;
        p.setX(a);
        c = new ArrayList();
        p = new Point(5, 6);
        c.add(p);
        c = new ArrayList();
        c.add(new Point(7,8));
        c.clear();
        c.add(p);
        
    }
    
    // 我的推断
    // str:hello
    // a:1
    // p:(5, 6) XXXX
    // c:[(5, 6)] XXXX
}


```
- **Java 中只有值传递** p 和 c 也是 值传递的。
```
(一)
main：
main.str ---> "hello"                String："hello"
main.a ---->  1
main.p -----> p 的地址                Point:p(1,2)         
                                后面改成了 --> （2, 2)
main.c -----> 其中第一个元素存着 p 的地址

(二)
由于是 值传递， 调用 dosome(a, str, p, c)，先
dosome:
dosome.str: ----> str 的地址
dosome.a  : ----> 1
dosome.p  : ----> p 的地址
dosome.c  : ----> 第一个元素对应p的地址。

str = str + "world";  
==> dosome.str = dosome.str + "world" = "hello" + "world" 
==> doeome.str = "helloworld";
                                          String: "helloWorld"

a = a + 1;
==> dosome.a = dosome.a + 1; 
==> dosome.a = 2;

p.setX(2);
==> dosome.p.对应对象.setX(2) 
==> Point:p(1,2)-->                 [main:Point:p(2,2)]
==> Point:p(2,2)

c = new ArrayList();
==> dosome.c = new ArrayList();

p = new Point();
==> dosome.p = new Point(5, 6);

c.add(p);
==> dosome.c.add(dosome.p);
==> dosome.c --> [(5, 6)]

c = new ArrayList();
==> dosome.c = new ArrayList();
==> dosome.c = [];

c.add(new Point(7, 8));
==> dosome.c ---> [(7, 8)];

c.clear()
==> dosome.c ---> []

c.add(p)
==> dosome.c.add(dosome.p)
==> dosome.c ---> [(5, 6)]


(三)
System.out.println("str:" + str);
System.out.println("a:" + a);
System.out.println("p:" + p);
System.out.println("c:" + c);

输出的都是 main 中的变量：
main.str ---> "hello"
main.a   ---> 1
main.p   ---> (2, 2)
main.c   ---> [(2, 2)]
```






4. contains() 的判定基于集合中元素的 equals 方法的比较结果。

```java
package collection;

import java.util.ArrayList;
import java.util.Collection;

public class ContainsDemo {
    public static void main(String[] args) {
        Collection<Point> c = new ArrayList();
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p1==p2: "+(p1==p2));
        System.out.println("p1.equals(p2): "+(p1.equals(p2)));
        System.out.println("c: " + c);
        c.add(p1);
        System.out.println("c added p1: "+p1);
        System.out.println("c: " + c);
        System.out.println("c contains p2" + p2 + ": " + (c.contains(p2)));
        
    }
}
```


### 集合间的操作

#### 并集 -- addAll()
#### 交集 -- retainAll()
#### 补集 -- removeAll()
```java
package collection;

import java.util.Collection;
import java.util.HashSet;

public class AddRemoveRetainAllDemo {
    public static void main(String[] args) {
        Collection<String> c1 = new HashSet<>();
        c1.add("java");
        c1.add("c++");
        c1.add(".net");
        
        System.out.println(c1);
        
        Collection<String> c2 = new HashSet<>();
        c2.add("php");
        c2.add("ios");
        c2.add("java");
        
        System.out.println(c2);
        
        c2.addAll(c1);
        System.out.println(c2);
        
        c2.retainAll(c1);
        System.out.println(c2);
        
        c2.removeAll(c1);
        System.out.println(c2);
    }
}
```


### 集合通过迭代器遍历集合中的元素。

`Iterator iterator()` 返回当前集合的一个迭代器。

使用迭代器遍历集合的步骤：问、取、删
- **迭代器遍历集合的过程中，不可以通过集合的方法增删元素。**否则会报出 **并发修改异常**。
```java
public interface Iterator<E> {
    // Returns true if the iteration has more elements.
    boolean hasNext();

    // Returns the next element in the iteration.
    E next();

    // Removes from the underlying collection the last element returned by this iterator 删除迭代器最近返回的元素
    default void remove() {
        throw new UnsupportedOperationException("remove");
    }
     /**
     * Performs the given action for each remaining element until all elements
     * have been processed or the action throws an exception.
     */
    default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }
}
```
```java
package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("上才艺~");
        c.add("E");
        c.add("D");
        c.add("M");
        c.add("EDM~");
        c.add("EDM~");
        
        Iterator it = c.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
            it.remove();
        }
        System.out.println(c);
    }
}
```
```java
上才艺~
E
D
M
EDM~
EDM~
[]
```

### removeIf

### forEach
JDK 8 之后，集合推出了一个新的方法`forEach()`，可以使用 lambda 表达式进行遍历。
如果一个集合是并发安全的集合，使用`forEach()`遍历集合是可以增删元素互斥的。

而使用迭代器遍历集合，哪怕这个集合是线程安全的，也需要你手动实现查删之间的互斥。
```java
package collection;

import java.util.ArrayList;
import java.util.Collection;

public class ForEachDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c);
        
        c.forEach(
            (s) -> System.out.println(s)
        );
    }
}
```
```
[one, two, three, four, five]
one
two
three
four
five

```

# 集合的工具类 Collections
## <T> List<T> synchronizedList(List<T> list);
将一个线性表转为线程安全的线性表。
```java
public class ForEachDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c);
        
        c.forEach(
            (s) -> System.out.println(s)
        );
        
        /*
         * 将现有集合转换为并发安全的集合
         */
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        System.out.println(list);
        list = Collections.synchronizedList(list);
    }
}
```

```java
public class ForEachDemo2 {
    public static void main(String[] args) {
        // 创建一个线程安全的集合
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        
        Thread t1 = new Thread() {
            public void run() {
                System.out.println(list);
                for (String string : list) {
                    System.out.println(string);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(getName() + ":遍历集合完毕");
            }
        };
        
        Thread t2 = new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + ":开始添加新元素");
                list.add("6");
                System.out.println(getName() + ":新元素添加完毕");
            }
        };
        t1.start();
        t2.start();
    }
}
```
控制台输出：
```java
public class ForEachDemo2 {
    public static void main(String[] args) {
        // 创建一个线程安全的集合
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        
        Thread t1 = new Thread() {
            public void run() {
                System.out.println(list);
                for (String string : list) {
                    System.out.println(string);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(getName() + ":遍历集合完毕");
            }
        };
        
        Thread t2 = new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + ":开始添加新元素");
                list.add("6");
                System.out.println(getName() + ":新元素添加完毕");
            }
        };
        t1.start();
        t2.start();
    }
}

```
```
[1, 2, 3, 4, 5]
1
2
Thread-1:开始添加新元素
Thread-1:新元素添加完毕
Exception in thread "Thread-0" java.util.ConcurrentModificationException
    at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
    at java.util.ArrayList$Itr.next(ArrayList.java:859)
    at collection.ForEachDemo2$1.run(ForEachDemo2.java:20)
```
使用新循环，哪怕是线程安全的集合，增删 与 查之间都不是互斥的，同时执行增与查，会抛出并发修改的异常。

需要自行处理好互斥关系，实现同步：
但是 forEach 则不同：
foreach 是同步的。
foreach 是集合的方法，不是迭代器的方法。
```java
package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForEachDemo2 {
    public static void main(String[] args) {
        // 创建一个线程安全的集合
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        Thread t1 = new Thread() {
            public void run() {
                System.out.println(list);
                list.forEach(
                    (element) -> {
                        System.out.println(element);
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                );
                System.out.println(getName() + ":遍历集合完毕");
                
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + ":开始添加新元素");
                list.add("6");
                System.out.println(getName() + ":添加新元素完毕");
                System.out.println(getName() + list);
            }
        };
        t1.start();
        t2.start();
    }
}
```
控制台输出：
```
[1, 2, 3, 4, 5]
1
2
Thread-1:开始添加新元素
3
4
5
Thread-1:添加新元素完毕
Thread-1[1, 2, 3, 4, 5, 6]
Thread-0:遍历集合完毕

```

可以看到 foreach running 时，其他线程是处于阻塞状态的。
foreach 的线程运行完毕之后，另一个线程才对集合进行添加的操作。


# 常见面试题：

## 1. Array 与 ArrayList 的区别？
1. Array 长度是静态固定的； ArrayList 的长度是动态变化的。
2. Array 可以存放基本类型和引用类型；ArrayList 只能存放引用类型，存放基本类型的时候，需要将基本类型转换为包装类。
