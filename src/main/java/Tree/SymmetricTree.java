package Tree;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/13 10:40
 * @Description:给定二叉树，检查它是否是自身的镜像（即，围绕其中心对称）。
 * 例如，这个二叉树[1,2,2,3,4,4,3]是对称的：
 *      1
 *
 *     /  \
 *
 *   2    2
 *
 *  / \    / \
 *
 * 3  4  4  3
 *
 * 但是以下[1,2,2，null，3，null，3]不是：
 *
 *     1
 *
 *    / \
 *
 *  2   2
 *
 *   \     \
 *
 *    3    3
 */
public class SymmetricTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    public boolean isSymmtric(TreeNode p){
       return  isSame(p.left,p.right);
    }

    /***
     * 判断树是否镜像，只需要判断左右子树，相对的节点是否相同
     * @param q
     * @param p
     * @return
     */
    public boolean isSame(TreeNode p,TreeNode q){
        if (p == null || q == null){
            return  q == p;
        }
        boolean f = q.val == p.val;
        boolean f2 = isSame(p.left , q.right);
        boolean f3 = isSame(p.right,q.left);
        return f && f2 &&f3;
    }
}
