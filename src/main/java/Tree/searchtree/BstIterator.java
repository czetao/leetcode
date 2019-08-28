package Tree.searchtree;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/21 22:11
 * @Description:
 */
public class BstIterator {
    class BSTIterator {


        Queue<Integer> queue = new LinkedList<>();
        //中序遍历root，得到一个升序的数组
        public BSTIterator(TreeNode root) {
            deliveNode(root);

        }

        public Queue<Integer> deliveNode(TreeNode root){
            if (root == null ) {
                return queue;
            }
            deliveNode(root.left);
            queue.add(root.val);
            deliveNode(root.right);

            return queue;
        }

        /** @return the next smallest number */
        public int next() {
            return queue.remove();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return queue.isEmpty();
        }
    }

}
