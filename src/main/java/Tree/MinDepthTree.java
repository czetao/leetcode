package Tree;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/18 21:24
 * @Description: 给定二叉树，找到它的最小深度。最小深度是沿从根节点到最近的叶节点的最短路径上的节点数。
 * 叶子节点是没有子节点的节点。
 */
public class MinDepthTree {

    /***
     * 两种特殊情况  1.树为空，深度0 2.只有根节点，深度1
     * 普通情况，当某一节点的左子节点为空时，这时我们需要求其右子节点的最短路径；当某一节点的右子节点为空时，
     * 这时我们需要求其左子节点的最短路径；当某一节点的左子节点和右子节点都不为空时，这时我们要求其左子树和右子树的最短路径。
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.right == null && root.left == null){
            return 1;
        }
        if (root.left == null){
            return minDepth(root.right)+1;
        }
        if (root.right ==null){
            return minDepth(root.left)+1;
        }
        return 1+Math.min(minDepth(root.right),minDepth(root.left));

    }
}
