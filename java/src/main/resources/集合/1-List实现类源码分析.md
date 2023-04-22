### Arraylist
#### 特点
- 实现了 List 接口，**存储有序的、可以重复**的数据
- 底层使用 `Object[]` 数组存储
- **线程不安全的**

#### ArrayList 源码解析
##### jdk1.7
```java
// 底层会初始化数组，数组的长度为10，Object[] elementData = new Object[10];
ArrayList<String> list = new ArrayList<>();

list.add("AA"); // elementData[0] = "AA";
list.add("BB"); // elementData[1] = "BB";
```
当要添加第11个元素的时候，底层的 elementData 数组已满，则需要扩容。
默认扩容为原来长度的1.5倍，并将原有数组中的元素复制到新的数组中。


##### jdk1.8
```java
// 底层会初始化数组，即：Object[] elementData = new Object[]{};
ArrayList<String> list = new ArrayList<>();

// 首次添加元素时，会初始化数组 elementData = new Object[10];elementData[0] = "AA";
list.add("AA");
list.add("BB"); // elementData[1] = "BB";
```
当要添加第11个元素的时候，底层的 elementData 数组已满，则需要扩容。
默认扩容为原来长度的1.5倍，并将原有数组中的元素复制到新的数组中。

##### 小结
jdk1.7中，ArrayList类似于饿汉式。
jdk1.8中，ArrayList类似于懒汉式。

### Vector
#### 特点
- 实现了 List 接口，**存储有序的、可以重复**的数据
- 底层使用 `Object[]` 数组存储
- **线程安全的**

#### Vector 源码解析
##### jdk1.8
```java
// 底层会初始化数组，数组的长度为10，Object[] elementData = new Object[10];
Vector<String> v = new Vector<>();

v.add("AA"); // elementData[0] = "AA";
v.add("BB"); // elementData[1] = "BB";
```
当要添加第11个元素的时候，底层的 elementData 数组已满，则需要扩容。
默认扩容为原来长度的2倍，并将原有数组中的元素复制到新的数组中。

### LinkedList
#### 特点
- 实现了 List 接口，**存储有序的、可以重复**的数据
- 底层使用双向链表存储
- 线程不安全的

#### LinkedList 源码解析
```java
LinkedList<String> list = new LinkedList<>(); // 底层没做啥
        
// 将"AA"封装到一个Node对象1中，list对象的属性first,last都指向此Node对象1
list.add("AA");
// 将"AA"封装到一个Node对象2中，对象1和对象2构成一个双向链表, 同时last指向此Node对象2
list.add("BB");

class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;
}
```
LinkedList 使用的是双向链表，所以**不存在扩容问题**。

### 开发建议
- ArrayList 底层使用数组
  - 查找和添加(尾部添加)操作效率高，时间复杂度为O(1)
  - 删除和插入效率低，时间复杂度为O(n)
- LinkedList 底层使用双向链表
  - 查找和添加(尾部添加)操作效率低，时间复杂度为O(n)
  - 删除和插入效率低，时间复杂度为O(1)

在选择 ArrayList 的前提下，`new ArrayList()`：底层创建长度为10的数组，
`new ArrayList(int capacity)`：底层创建指定 capacity 长度的数组

如果开发中，能够大致确认数组的长度，推荐使用后者，避免了底层的扩容和复制数组的操作。
