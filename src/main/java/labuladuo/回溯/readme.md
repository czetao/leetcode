- 回溯的基本框架
- 所有的回溯算法 都可以画成一颗树
- 递归 代表着树的深度 nums  for i 代表树的广度
- 解题过程 尝试将其画成树, 会更容易理解
- 全排列, 从头开始 for i = 0 无序的
- 子集, 组合, for i= startIndex 有序的 [1,2] [2,1] 则排除掉[2,1]
- 从下图中红线部分可以看出，在集合[1,2,3,4]取1之后，下一层递归，就要在[2,3,4]中取数了，那么下一层递归如何知道从[2,3,4]中取数呢，靠的就是startIndex。
- 如果下一层递归要继续从当前值开始选(可重复选), 则backtracking( i ),往下递归的时候,i就不+1了   