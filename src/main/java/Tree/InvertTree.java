package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/18 22:02
 * @Description:反转二叉树
 * 输入：
 *     4
 *    / \
 *   2   7
 *  / \ / \
 * 1  3 6  9
 * 输出：
 *     4
 *    / \
 *   7   2
 *  / \ / \
 * 9  6 3  1
 */
public class InvertTree {

    /**
     * 关键代码只有3行，根节点的位置是不变的，只需要将左右节点互换即可。
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        //左右节点互换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /***
     * 利用队列，借助其先进先出的特性。
     * 在进行循环进队列、出队列的操作时，核心代码还是最开始那三行代码，进行左右子节点互换。
     * @param root
     * @return
     */
    public TreeNode invertTree3(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root !=null){
            q.add(root);
        }
        while (!q.isEmpty()){
            TreeNode d = q.poll();
            TreeNode temp = d.left;
            d.left = d.right;
            d.right = temp;
            if (d.left != null){
                q.add(d.left);
            }
            if (d.right != null){
                q.add(d.right);
            }

        }
        return root;



    }



    public static void main(String[] args) {
        boolean a=true,b=false;
        System.out.println(a==true && b==false);

        System.out.println(a);
    }
}
