package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/19 16:05
 * @Description:
 */
public class N_aryTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /***
     * 广度优先算法（BFS）
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> currrent = new ArrayList<>();
            int length = queue.size();
            for (int i=0;i<length;i++){
                Node curr = queue.poll();
                currrent.add(curr.val);
                for (Node n:curr.children){
                    queue.offer(n);
                }
            }
            result.add(currrent);
        }
        return result;
    }
}
