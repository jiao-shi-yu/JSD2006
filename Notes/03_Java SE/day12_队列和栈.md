# 队列 queue

- 队列是一种特殊的线性表，它只能从表的一端添加元素、另一端删除元素。
- 并且遵循先进先出的原则。
- LinkedList 在增删操作上效率很好，是队列的实现类。

## 常用方法
- `boolean offer(E e)`: 向队尾添加元素，入队操作。
- `E poll()`: 获取队首元素，并将其从队列中移除。出队操作。
- `E peek()`: 获取队首元素，但不会将其从队列中移除。


```java
public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");
        queue.offer("five");
        
        System.out.println("queue:" + queue);
        
        String head = queue.poll();
        System.out.println("head:" + head);
        System.out.println("queue after poll:" + queue);
        String newHead = queue.peek();
        System.out.println("newHead:" + newHead);
        System.out.println("queue after peek:" + queue);
    }
}
```
输出：
```
queue:[one, two, three, four, five]
head:one
queue after poll:[two, three, four, five]
newHead:two
queue after peek:[two, three, four, five]

```

> 需要注意的一点是：想要遍历队列并删除的话，需要用到的是 while 循环，结合队列的 size();

```java
        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }
```
输出：
```java
two
three
four
five
```
## 双端队列
Double Ended Queue, 在队列的基础上，两端既可以入队，又可以出队。

入队和出队操作区分方向：

- 队首对应的是 first
    + `boolean offerFirst`:在双端队列的前端入队
    + `E pollFirst()`: 在双端队列的前端出队
- 队尾对应的是 last
    + `boolean offerLast`:在双端队列的后端入队
    + `E pollLast()`: 在后端出队。
```java
public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        
        deque.offerFirst("one");
        System.out.println(deque);
        deque.offerFirst("two");
        System.out.println(deque);
        deque.offerLast("three");
        System.out.println(deque);
        
        System.out.println("pollFirst: " + deque.pollFirst());
        System.out.println("pollLast: " + deque.pollLast());
    }
}
```
```
[one]
[two, one]
[two, one, three]
pollFirst: two
pollLast: three
```

# 栈 stack

- 只允许一端添加或删除元素的线性表。
- 遵循先入后出的原则。
- 可以看做是只允许一端操作元素的双端队列。
- 集合有 Stack 类，但是用双端队列就可以实现。

## 常用方法
- `void push()`: 压栈，等效于`void addFirst()`，跟`boolean offerFirst()`差不多。
- `E pop()`: 弹栈，等效于`void removeFirst()`， 跟`E pollFisrt()`差不多。 如果是一个空栈，pop()报错，而 pollFirst()会得到一个 null, 不会报错。

```java
public class StackDemo {
    public static void main(String[] args) {
        Deque<String> stack = new LinkedList<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        stack.push("five");
        System.out.println(stack);
        while(stack.size()>0) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.pollFirst());
        stack.pop();
    }
}
```
```
[five, four, three, two, one]
five
four
three
two
one
null
Exception in thread "main" java.util.NoSuchElementException
    at java.util.LinkedList.removeFirst(LinkedList.java:270)
    at java.util.LinkedList.pop(LinkedList.java:801)
    at collection.stack.StackDemo.main(StackDemo.java:19)
```




