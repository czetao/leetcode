package previous.Tree.searchtree;

import previous.Tree.TreeNode;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/22 00:30
 * @Description: 二叉树插入  返回插入后二叉树的根节点
 */
public class InsertSearchTree {

    /***
     * 递归三要素
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //1.递归终止条件
        if (root == null){
            return new TreeNode(val);
        }
        //2.每一次递归做的事
        if (root.val > val){
            root.left = insertIntoBST(root.left,val);

        }else if (root.val<val){
            root.right = insertIntoBST(root.right,val);

        }
        return root;
    }
}
