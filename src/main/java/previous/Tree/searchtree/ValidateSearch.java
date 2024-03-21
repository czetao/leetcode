package previous.Tree.searchtree;

import previous.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/21 21:40
 * @Description: 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class ValidateSearch {
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long min, long hign) {
        if (root == null){
            return true;
        }


        //失败的条件
        if (root.val >= hign || root.val <= min){
            return false;
        }
        //一个巧妙的递归
        return isValid(root.left,min,root.val) && isValid(root.right,root.val,hign);
    }

}
