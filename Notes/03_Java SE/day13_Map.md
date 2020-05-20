# Map
查找表， Map 体现的样子是一个多行两列的表格，其中左列称为 key, 右列称为 value. 并且 Map 总是根据 key 来获取对应的 value.

因此我们可以将要查询的数据作为 value, 查询条件作为 key ，向 Map 中存放元素。

常用实现类：
java.util.HashMap 散列表
HashMap 是有散列算法实现的 Map，是当今世界上查询速度最快的数据结构。

## 常用方法

- `V put(K key, V value)`: 添加一个键值对，或根据键更新值。返回值是被替换的 value.
- `V get(K key)`: 根据键，获取值；不存在则返回 null.
- `boolean containsKey(Object key)`: 判断是否包含指定的键
- `boolean containsValue(Object value)`: 判断是够包含指定的值
示例：
```java
public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("语文", 99);
        map.put("数学", 98);
        map.put("英语", 97);
        map.put("物理", 96);
        map.put("化学", 95);
        System.out.println(map);
        map.put("语文", 100);
        System.out.println(map);
        
        int mathScore = map.get("数学");
        System.out.println("math score: " + mathScore);
        
        Integer peScore = map.get("体育");
        System.out.println("pe score: " + peScore);
        
        boolean containsPE = map.containsKey("体育");
        System.out.println("contains key P.E.: " + containsPE);
        boolean contains100 = map.containsValue(100);
        System.out.println("contains value 100: " + contains100);
    }
}

```
输出：
```
{物理=96, 数学=98, 化学=95, 语文=99, 英语=97}
{物理=96, 数学=98, 化学=95, 语文=100, 英语=97}
math score: 98
pe score: null
contains key P.E.: false
contains value 100: true

```


## 遍历 Map

- `Set<K> KeySet()`:返回 Map 中所有的 Key;
- `Set<Map.Entry<K, V>> entrySet()`: Entry 表示键值对，英语是条目的意思。 entrySet() 将 Map 中的所有键值对返回。
- `Collection<V> values()`: 返回 Map 中所有出现的值。
```java
public class IterateMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("语文", 99);
        map.put("数学", 98);
        map.put("英语", 97);
        map.put("物理", 96);
        map.put("化学", 95);
        
        Set<String> keys = map.keySet();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Collection<Integer> values = map.values();
        
        for (String key : keys) {
            System.out.print(key + ",\t");
        }
        System.out.println();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + "-->" +  entry.getValue());
        }
        for (Integer value: values) {
            System.out.print(value+",\t");
        }
    }
}
```
输出：
```
物理, 数学, 化学, 语文, 英语, 
物理-->96
数学-->98
化学-->95
语文-->99
英语-->97
96, 98, 95, 99, 97, 
```



























