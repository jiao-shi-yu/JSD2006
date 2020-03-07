# 5.2 Spring IoC
## 5.2 通过SET方式注入值
### 5.2 注入List集合类型
```
<list name="skills"><property><value>Java SE</value></property></list>
```


##### 关于List与Set集合
`List`与`Set`都是`Collection`的子接口。


`List`集合是序列的，并且集合中的元素可以重复，在内存中是连续的地址。
`Set`j