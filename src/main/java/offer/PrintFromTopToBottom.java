package offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/16 15:59
 * @Description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {
     class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
             this.val = val;

         }
     }

         /***
          * 通过队列先进先出的思想
          * @param root
          * @return
          */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return list;
        }
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.pop();
            list.add(node.val);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return list;
    }
}
