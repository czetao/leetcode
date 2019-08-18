package Tree;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/18 23:11
 * @Description: 给定二叉搜索树（BST），找到BST中两个给定节点的最低共同祖先（LCA）。根据维基百科上LCA的定义：
 * “最低共同祖先在两个节点p和q之间定义为T中的最低节点，其中p和q都是后代（我们允许节点成为其自身的后代）。”
 */
public class CommonTree {

    /***
     * 如果p和q，大于 与 小于当前根节点，此根节点就是最低的共同祖先（LCA）
    * @param root 根节点
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }else {
                return root;
            }
        }
        return root ;
    }
}
