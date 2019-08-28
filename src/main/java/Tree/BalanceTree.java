package Tree;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/18 15:45
 * @Description: 给定二叉树，判断它是否是高度平衡的。对于此问题，
 * 高度平衡二叉树定义为：一个二叉树，其中每个节点的两个子树的深度从不相差超过1。
 */
public class BalanceTree {
    public boolean isBalanced(TreeNode root) {
        //如果是空树，也是平衡二叉树
        if (root == null){
            return true;
        }
        int dep = getDeepth(root);

        return dep >=0;
    }

    /***
     * 借用计算树深度的算法，只需要在对树的深度进行判断即可，绝对值<1;
     * @param root
     * @return
     */
    public int getDeepth(TreeNode root){
        if (root ==null){
            return 0;
        }
        int left = getDeepth(root.left);
        int right = getDeepth(root.right);
        //对每一个结点的深度进行判断，不符合返回-1，符合返回二叉树的深度
        if (left == -1 || right == -1 || Math.abs(left-right)>1){
            return -1;
        }
        return 1+Math.max(left,right);
    }
}
