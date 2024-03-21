package previous.Tree;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/13 11:24
 * @Description: 。给定二叉树，找到它的最大深度。最大深度是从根节点到最远叶节点的最长路径上的节点数。叶子是没有子节点的节点。
 */
public class DepthTree {

    /***
     * 递归到最下一层，往上逐级加1
     * @param root
     * @return
     */
    public int DepthTree(TreeNode root){
        if (root == null){
            return 0;
        }
        int left =DepthTree(root.left);
        int right = DepthTree(root.right);
        return 1+ Math.max(left,right);
    }


}
