# ArrayList 和 LinkedList
List 接口是 Collection 的子接口，用于定义现行表数据结构。
可以将 List 理解为存放对象的数组，只不过其元素个数可以动态的增加或减少。

List 接口的两个常见实现类为 ArrayList 和 LinkedList，分别用动态数组和链表的方式实现了 List 接口。

可以认为 ArrayList 和 LinkedList 的方法在逻辑上完全一样，
只是在性能上有一定的差别。
ArrayList 更适合于随机访问，而 LinkedList 更适合于插入和删除。


# List 常用方法
## 获取元素 List 是有序集合，可以根据下标位置获取元素。
`E get(int index)`: 获取指定下标位置的元素。
## 遍历
1. foreach 循环
2. 普通的循环也可以遍历 List

## 替换元素
`E set(int index, E element)`：指定元素替换指定位置的元素。

如果指定的 index >= list.size()，就会抛出 IndexOfOfBoundsException. 

```java
package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        
        System.out.println("list:" + list);
        
        String str = list.get(0);
        
        System.out.println("使用 for 循环遍历线性表：");
        for (int i = 0; i < list.size(); i++) {
            str = list.get(i);
            System.out.printf( "\t%d %s%n", i, str);
        }
        

        String old = list.set(0, "zero");
        
        System.out.println("list:" + list);
        
        System.out.println("old:" + old);
        
        //list.set(99, "ninty-nine");
    }
}
```

### 将List倒序

> 不要少考虑了一层：长度/2. 否则就是换过来，又换回去。

```java
package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ReverseDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        // 创建新集合的情况下，将集合倒序排列
        for (int i = 0; i < list.size()/2; i++) {
            String right = list.set(list.size()-1-i, list.get(i));
            list.set(i, right);
        }
        System.out.println(list);
    }
}
```

## 重载后的 add、 remove 方法
- `void add(int index, E element)`: 在指定位置插入指定元素，原来的元素及后续元素向右移动。
- `E remove(int index)`: 删除指定位置的元素并返回。
```java
package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        
        list.add(3, "3");
        
        System.out.println(list);
        
        String old = list.remove(3);
        System.out.println(list);
        System.out.println(old);
    }
}
/*Output
[zero, one, two, 3, three, four, five]
[zero, one, two, three, four, five]
3
*/
```

## indexOf 和 lastIndexOf
- `int indexOf(Object o)`: 返回指定对象第一次出现的位置
- `int lastIndexOf(Object o)`: list 是可重复集， lastIndexOf 返回指定对象最后一次出现的位置。
```java
package collection.list;

import java.util.ArrayList;
import java.util.List;

public class IndexOfDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("one");
        list.add("two");
        System.out.println(list);
        System.out.println("index of \"one\": "+list.indexOf("one"));
        System.out.println("last index of \"one\": "+list.lastIndexOf("one"));
    }
}
```
控制台输出：
```
[one, two, one, two]
index of "one": 0
last index of "one": 2
```


## subList
- `List<E> subList(int fromIndex, int toIndex);`
- 对子集的操作就是对原集合的操作
```java
package collection.list;

import java.util.ArrayList;
import java.util.List;

public class SubListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        
        List<String> sublist = list.subList(3, 5);
        System.out.println(sublist);
        sublist.clear();
        System.out.println(list);
        
    }
}

```
控制台输出：
```
[three, four]
[zero, one, two, five, six]

```

## `Object[] toArray()` 与 `<T> T[] toArray(T[] a);`
源代码：
```java
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    <T> T[] toArray(T[] a);

```
- 调用了 Arrays.copyOf() 静态方法。
示例代码：
```java
package collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToArrayDemo {
    public static void main(String[] args) {
        List<String> list  = new ArrayList<>();
        
        list.add("one");
        list.add("two");
        list.add("three");
        
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));
        
        String[] strs = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(strs));
        
    }
}
```
控制台输出：
```
[one, two, three]
[one, two, three]
```
- 用到了 Arrays.toString() 方法。

# Arrays.asList() 数组的工具类，提供了一个静态方法 asList() 可以将数组转换为一个 List 集合。
```java
package collection.list;


import java.util.Arrays;
import java.util.List;

public class ArraysAsListDemo {
    public static void main(String[] args) {
        String[] array = {"one", "two", "three", "four"};
        List<String> list = Arrays.asList(array);
        System.out.println(Arrays.toString(array));
        System.out.println(list);
        
        list.set(0, "1");
        System.out.println(list);
        System.out.println(Arrays.toString(array));     
        list.add("five");
    }
}

```
控制台输出：
```java
[one, two, three, four]
[one, two, three, four]
[1, two, three, four]
[1, two, three, four]

```
- asList()方法得到的集合，是基于原数组的。
- **对集合的操作，就是对原数组的操作**

- 所以不能 add() , 那样就变成一个新数组了。

```
[one, two, three, four]
[one, two, three, four]
[1, two, three, four]
[1, two, three, four]
Exception in thread "main" java.lang.UnsupportedOperationException
    at java.util.AbstractList.add(AbstractList.java:148)
    at java.util.AbstractList.add(AbstractList.java:108)
    at collection.list.ArraysAsListDemo.main(ArraysAsListDemo.java:17)

```































