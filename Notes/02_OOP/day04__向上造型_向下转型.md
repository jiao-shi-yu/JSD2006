# 向上转型(upcasting)和向下转型(downcasting)

## 首先，明确一点：
**父类引用可以指向子类对象，而子类引用不能指向父类对象**。


## 然后，向上转型就是
把子类对象直接赋给父类引用。向上转型不用类型强转。  
如`Animal animal = new Bird();`

## 向下转型是
一个父类引用，它实际上是，指向了子类对象。把这个父类引用赋值给子类引用的过程叫向下转型。向下转型是指把指向了子类对象的父类引用赋值给子类引用。
向下转型，需要强制转换。如果父类引用指向的对象，并不是该子类的对象，就会报错。
如:
```java
Animal animal = new Bird();
Bird bird = (Bird) animal;
```


# 向上造型的意义？

提高代码的可扩展性，比如说：
比如说，我定义一个方法，参数类型是 Animal。
那我调用方法的时候，传入的参数可以是 Animal 类型的对象，也可以是 Animal 的多种子类对象， Bird \ Dog \ Monkey 等等。
