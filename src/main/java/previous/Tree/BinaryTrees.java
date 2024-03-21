package previous.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/19 10:23
 * @Description: 给定二叉树，返回所有根到叶路径。
 */
public class BinaryTrees {

    /***
     *
     * @param root
     * @return
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null ){
            return list;
        }
        bianryTree(root,list,"");
        return list;
    }

    private static void bianryTree(TreeNode root, List<String> list, String s) {
        if (root.right == null && root.left ==null){
           list.add(s+ root.val);
        }
        if (root.right != null){
            bianryTree(root.right,list,s+root.val+"->");
       }
       if (root.left != null){
           bianryTree(root.left,list,s+root.val+"->");
       }

    }

    /***
     * 借用两个栈，一个存储节点信息，一个存储路径信息
     * @param root
     * @return
     */
    public static List<String> binaryTreePaths3(TreeNode root) {
        List<String> list = new ArrayList<>();
        Stack<TreeNode> sNode = new Stack<>();
        Stack<String> sStr = new Stack<>();
        if (root ==null){
            return list;
        }
        sNode.push(root);
        sStr.push("");
        while (!sNode.isEmpty()){
            TreeNode curNode = sNode.pop();
            String curStr = sStr.pop();
            if (curNode.left == null && curNode.right == null) {
                list.add(curStr + curNode.val);
            }
            if (curNode.left != null) {
                sNode.push(curNode.left);
                sStr.push(curStr + curNode.val + "->");
            }
            if (curNode.right != null) {
                sNode.push(curNode.right);
                sStr.push(curStr + curNode.val + "->");
            }
        }
        return list;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> strings = binaryTreePaths(root);
        System.out.println(strings);
    }
}
