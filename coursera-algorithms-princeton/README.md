# Coursera Princeton Algorithms 编程题总结

## 第1周 

### Percolation
本周编程作业是Percolation，求解渗透问题，并通过Monte Carlo方法模拟找到渗透的阈值。

#### Percolation
用一个NxN的格子表示percolation系统，每一个格子是打开或者关闭，打开是白色关闭是黑色。
如果一个格子是full，首先他必须是打开的，然后表示从最顶上通过相连(4方向)的打开的格子可以渗透到这个位置。
当一个系统是percolates，表示能从最顶层渗透到最底层，也就是说，最底层存在打开的格子是full。

暴力方法时间复杂度太高，需要进行一些优化。

1. 加入虚拟节点。首虚拟节点与第一层所有打开的元素相关联，尾虚拟节点和最后一层所有打开的节点相关联。如果首尾虚拟节点在一个集合中，那么系统是渗透成功的。
但是也会出现一个问题（backwash），因为有一些格子虽然从上面不能渗透到，但和尾虚拟节点连接后，他们也和首虚拟节点在一个集合了。

2. 使用两个并查集避免backwash。一个只负责维护首虚拟节点，当进行isFull判断是否只考虑这个并查集，另一个并查集进行首尾虚拟节点的维护，用在percolates的判断中。

具体实现代码可见[Percolation](/coursera-algorithms-princeton/src/main/java/one/Percolation.java)。

#### Monte Carlo simulation
Monte Carlo方法模拟多次渗透系统，知道渗透的阈值。代码可见[PercolationStats](/coursera-algorithms-princeton/src/main/java/one/PercolationStats.java)。

## 第2周 

### Deques and Randomized Queues
本周编程作业是Deques and Randomized Queues，用数组和链表实现双端队列和随机队列，主要是练习泛型和迭代器。

#### Dequeue
Dequeue是一个双端队列，它是栈和队列的升级版，支持首尾两端的插入和删除。要实现给定的API，并注意Corner cases。
时间复杂度上，要求每个Dequeue操作和迭代器操作必须是常数时间；空间复杂度上，对于n个元素，使用的内存应该为48n + 192 bytes。
小技巧就是使用课程中说到的哨兵sentinel来辅助实现Dequeue。
代码可见[Deque](/src/main/java/two/Deque.java)。

#### Randomized queue
Randomized queue和栈、队列十分相似，区别在于remove操作是随机删除一个元素。性能要求和Dequeue类似。
代码可见[RandomizedQueue](/src/main/java/two/RandomizedQueue.java)。


## 第3周

### Collinear Points
本周的编程作业是Collinear Points，从给定的点寻找共线。需要完成的任务有两个：Brute force实现和A faster sorting-based solution实现。

#### Brute force
暴力方法比较简单，直接枚举点p、q、r、s，判断任意两点是否斜率相同，如果是，则4点共线。这里不要求寻找5点及以上共线。时间复杂度为O(n^4)，空间复杂度O(n)。
代码可见[BruteCollinearPoints](/src/main/java/three/BruteCollinearPoints.java)。

#### A faster sorting-based solution
快速方法使用一种基于排序的策略：选定起始点p，对每个q，计算pq的斜率并排序，检查序列中是否有3个以及上相邻点有相同的斜率。
如果存在，则表示这些点共线。时间复杂度为O(n)+O(log n)+O(n)，分别对应枚举、排序和遍历查找，空间复杂度还是为O(n)。
代码可见[FastCollinearPoints](/src/main/java/three/FastCollinearPoints.java)。


## 第4周

### 8 Puzzle
本周的编程作业是8 Puzzle，用最少步数求解8数独问题。

#### Best-first search
8数独是一个NP问题，没有有效解法，只能使用A*算法来启发式求解。定义一个Search Node，表示当前搜索情况的一种状态，记录了上一个状态和从初始状态到本状态的移动步数。
使用一个优先队列来存储Search Node，不断从PQ中去取Search Node扩展到下一状态，直到到达完成状态。衡量优先级别可以采用Hamming距离和Manhattan
距离。为了寻找到最少步数解法，同时采用Hamming和Manhattan距离，进行启发式搜索。

#### A critical optimization
在启发式搜索中，扩展Search Node状态的过程中，会扩展出已经出现过的状态，需要将其剔除。
具体操作就是，扩展出下一状态进行搜索时，不要将重复出现的前一个状态加入PQ中。

#### Game Tree
搜索过程就是一个博弈树的展开形式，root是初始状态，每个节点对应一个状态。每一步中，A*算法取PQ中优先级最小的节点，进行处理。

#### Detecting infeasible puzzles
8数独问题并不是一定可解的。可以通过交换任意行不为空白的相邻两个元素，进行可行性搜索。
具体操作就是，产生两个初始状态，其中一个不变，另一个交换某两个元素，同时进行A*搜索。
如果初始状态能找到目标解，则代表可行；若交换状态能找到目标解，则代表不可行。

#### 解法
通过上面的分析过程，写出具体算法已经不是很难。需要注意的是，作业评价对Solver类的内存要求很严格，需要好好考虑如何节省内存。
由于时间关系，本人提交的作业没有通过内存评价。具体代码可见[8 puzzle](/src/main/java/four)。

## 第5周

### Kd-Trees
本周的编程作业是Kd-Trees。要求使用2d-tree来实现区域内2维数据点的range search和nearest neighbor search。
需要完成的任务有两个：Brute-force 实现和 2d-tree 实现，两者的API是完全相同的。

#### Brute-force
暴力方法要求insert()和contains()是O(log n)的复杂度，要求nearest()和range()是O(N)的复杂度。
题目要求中也写明了可以使用algs4.jar中的SET或者java.util.TreeSet，这两个集合底层都是使用红黑树的，可以满足复杂度的要求。
代码比较简单，详细可见[PointSet](/src/main/java/five/PointSET.java)。

#### 2d-tree
2d-tre方法BST的实现。节点需要保存当前点、矩形块、左右子树和划分方向。划分方向用true表示X轴划分，用false表示y轴划分。
insert、get和draw都采用递归实现，十分简单；range和nearest采用BFS方法遍历2d-tree，根据说明的中的方法，进行剪枝得到结果。
整个代码参考BFS写法，还是比较简单的，详细代码可见[KdTree](/src/main/java/five/KdTree.java)。

