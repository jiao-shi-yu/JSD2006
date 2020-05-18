

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





### `Iterator<E> iterator();`
- 获取当前集合的迭代器。

#### 集合通过迭代器遍历集合中的元素。





### removeIf

#### forEach






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




# 常见面试题：

## 1. Array 与 ArrayList 的区别？
1. Array 长度是静态固定的； ArrayList 的长度是动态变化的。
2. Array 可以存放基本类型和引用类型；ArrayList 只能存放引用类型，存放基本类型的时候，需要将基本类型转换为包装类。
