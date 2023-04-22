### 客户端 API 操作

#### 创建 ZooKeeper 客户端
```java
public void init() throws IOException {
    String connectString = "139.196.149.231:2181";
    int sessionTimeout = 2000;
    zkClient = new ZooKeeper(connectString, sessionTimeout, watchedEvent -> {
    });
}
```
#### 创建子节点
参数：
1. 要创建的节点路径
2. 节点数据
3. 节点权限
4. 节点的类型
```java
public void create() throws InterruptedException, KeeperException {
    String nodeCreated = zkClient.create("/shu", "shu.avi".getBytes(),
            ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
}
```

#### 获取子节点并监听节点变化
```java
public void getChildren() throws InterruptedException, KeeperException {
    List<String> children = zkClient.getChildren("/", true);

    for (String child : children) {
        System.out.println(child);
    }
    Thread.sleep(Long.MAX_VALUE);
}
```

#### 判断 Znode 是否存在
```java
public void exist() throws Exception {
    Stat stat = zkClient.exists("/shu1", false);
    System.out.println(stat == null ? "not exist" : "exist");
}
```