# Union Find (并查集)

__高效解决数据间的连通性问题__

_主要包含 find, isConnection, union 方法_
> find : 查找point的连通标识 <br>
> isConnection : 返回point 间是否存在连通 <br>
> union : 将两个 point 间建立连通（改变point 的连通标识）

- UnionFindV1
```java
/** 我们通过素组建立一个集合，
* 默认将集合下标记作查找集，集合中的值作为关联性标识（默认互不连通）
*
* find：直接返回 point的连通标识
* isConnection：通过 find 返回的连通标识判断石头相等
* union：判断连通标识，不同时将其中pointA的连通标识相同都修改为pointB的连通标识
*
* 优点：find O(1)实现
* 
* 缺点：union 在多操作的情况下直接退化为 O^2的复杂度
* 
* /  

```

- UnionFindV2
```java
/**
* 相较于 UnionFindV1 增加了 parent 索引 
* 可以0(n)时间定位 父节点信息
* O(n)时间修改union 节点信息（两次find查找时间复杂度）
* 
* 优点：优化了union的修改操作时间复杂度
* 
* 缺点：union 会造成一部分情况 parent 查找树过高问题，find 时间复杂度依旧过高
* 
*/

```

- UnionFindV3
```java
/**
* 相较于 UnionFindV2 增加了 rSize(记录当前root节点大小) 索引 
* 均衡了 parent 的数高度，从而减小 find 操作的时间复杂度
* 
* 优点：～
* 
* 缺点：虽然在大多数情况下 可以优化数高，从而解决find 的查找时间复杂度高问题，
*       但在极端情况下依然会造成 parent 查找树过高问题；
* 
*/

```

- UnionFindV3Rank
```java
/**
* 相较于 UnionFindV2 将size 优化为 rank(基于根节点大小的排行索引，
* union时比较rank大小，小的往大的里面插入，均衡树高)
* (TODO,不是很懂) find 优化了查找方式，使用两部跳跃查找方式，加速 find 索引的速度，并将 树高降低接近O(1) 的时间复杂度
* 
* 优点：均衡了极端情况下的parent数畸形问题，优化了find 查找时间复杂度(接近O(1))
*/

```