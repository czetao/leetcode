package previous.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/18 14:36
 * @Description: 给定二叉树，返回其节点值的自下而上级别顺序遍历（即从左到右，逐层逐层）。
 */
public class Traversal2 {

    /***
     * 方法1 ： 使用队列，借助其先进先出的特点，一层一层遍历节点，
     * 将每一层遍历的节点值存入List中，再将List放入List2中，最后再倒序遍历List2存入List3中，List3就是最后的结果
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list2 = new ArrayList<>();
        if (root == null) {
            return list2;
        }
        List<Integer> list = null ;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        //通过两个while循环，将存放下一层节点的队列tem ,变换成q
        while (!q.isEmpty()){
            list = new ArrayList<>();
            Queue<TreeNode> tem = new LinkedList<>();
            while (!q.isEmpty()){
                TreeNode t = q.poll();
                list.add(t.val);
                if (t.left != null){
                    tem.add(t.left);
                }
                if (t.right != null){
                    tem.add(t.right);
                }
            }
            list2.add(list);
            q =tem;
        }

        // 此时 ，list2中存放的是自上而下遍历的树节点，通过反序遍历，返回自下而上的list
        List<List<Integer>> list3 = new ArrayList<>();
        for (int i = list2.size()-1;i>=0;i--){
            list3.add(list2.get(i));
        }

        return list3;
    }
}
