package previous.Tree.searchtree;

import previous.Tree.TreeNode;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/21 22:34
 * @Description: 二叉搜索树插入
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 */
public class SearchInSearchTree {
    /***
     * 当遇到多个判断时，可以利用条件判断符，进行选择判断
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
       /*if (root == null || root.val == val){
           return root;
       }
       return root.val>val ? searchBST(root.left,val):searchBST(root.right,val);*/

        if (root == null ){
            return null;
        }
        if (root.val ==val) {
            return root;
        }else if (root.val>val){
            return searchBST(root.left,val);
        }else if (root.val<val){
            return  searchBST(root.right,val);
        }
        //没找到，返回none
        return null;
        // }
    }

}
