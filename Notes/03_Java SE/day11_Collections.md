Collections 是集合的工具类，

里面提供了很多方法。


# sort
- `void sort(List list)`: 自然排序，从小到大。
```java
public class SortListDemo1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        
        Collections.reverse(list);
        System.out.println(list);
        
        
        
    }
}
```
控制台输出：
```
[6, 14, 34, 62, 53, 28, 23, 27, 28, 25]
[6, 14, 23, 25, 27, 28, 28, 34, 53, 62]
[62, 53, 34, 28, 28, 27, 25, 23, 14, 6]
```

- `void sort(List list, Comparator comparator)`;
传入两个参数，要排序的集合 和 一个比较器。
```java
import collection.Point;

public class SortListDemo2 {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(3, 4));
        list.add(new Point(8, 9));
        list.add(new Point(7, 3));
        list.add(new Point(2, 1));
        list.add(new Point(5, 6));
        // 编译不通过
        Collections.sort(list, new PointComparator());
        System.out.println(list);
    }
}

class PointComparator implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
        int d1 = o1.getX() * o1.getX() + o1.getY() * o2.getY();
        int d2 = o2.getX() * o2.getY() + o2.getY() * o2.getY();
        return d1 - d2;
    }
    
}
```
控制态输出：
```
[(2,1), (3,4), (7,3), (5,6), (8,9)]
```




# reverse
- 反转集合重元素的顺序

# shuffle

- 对集合进行随机排序。