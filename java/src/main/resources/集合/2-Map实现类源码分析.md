### HashMap
#### 特点
- 所有的 key 之间是**不可重复的、无序**的。所有的 key 构成了一个 Set 集合
  - key 所在的类要重写 `hashCode()` 和 `equals()` 方法
- 所有的 value 之间是**可重复的、无序**的。所有的 value 构成了一个 Collection 集合
  - value 所在的类要重写 `equals()` 方法
- 所有的 entry 之间是**不可重复的、无序**的。所有的 entry 构成了一个 Set 集合

#### HashMap 源码解析
##### JDK1.7

```java
// 创建对象的过程中，底层会初始化数组 Entry[] table = new Entry[16];
HashMap<String, Integer> map = new HashMap<>();

map.put("AA", 78); // "AA"和78封装到一个Entry对象中，考虑将此对象添加到table数组中


```

添加 / 修改的过程：将 (key1, value1) 添加到当前的 map 中
1. 调用 key1 所在类的 `hasCode()` 方法，计算 key1 对应的哈希值 hash1
2. hash1 经过哈希函数之后，得到 hash2
3. 通过 hash2，确定了元素在数组中的位置
   - 如果该位置没有元素，添加成功
   - 如果该位置有元素 (key2, value2)，则继续比较 key1 和 key2 的哈希值
     - 如果 key1 和 key2 的哈希值不相同，添加成功
     - 如果 key1 和 key2 的哈希值相同，继续比较
       - 调用 `equals()` 返回 true，添加成功 
       - 调用 `equals()` 返回 false，value2 用 value1 替换

随着不断地添加元素，在满足如下的条件情况下，会考虑扩容：
**当元素个数达到阈值（数组的长度 * 负载因子 默认为 16 * 0.75）就考虑扩容，默认扩容为原来的2倍**。
