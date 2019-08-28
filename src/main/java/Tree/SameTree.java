package Tree;


import java.util.TreeSet;

/***
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 示例 1:
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 */
public class SameTree {


    /***
     * 判断两棵树是否same，只需要每个位置的val是一样的
     * 利用递归，树为空时，递归结束
     * @param
     * @return
     */
    public boolean isSame(TreeNode p , TreeNode q){
        if (p == null || q == null){
            return q == p;
          }
    boolean f = p.val == q.val;
    boolean f2 =isSame(p.left,q.left);
    boolean f3 = isSame(p.right,q.right);

        return f && f2 && f3;
    }

}

