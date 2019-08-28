package Tree.searchtree;

import Tree.TreeNode;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/22 01:01
 * @Description: 删除二叉排序树的节点
 */
public class DeleteNode {
    /***
     * 1.找到要删除的节点
     * 2.根据删除的三种情况。对二叉排序树进行节点删除
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null){
            return null;
        }
        else if (root.val > key){
            //向左找,找到直接删除
            root.left = deleteNode(root.left,key);
            return root;
        }else if (root.val <key){
            //向右找
            root.right =  deleteNode(root.right,key);
            return root;
        }else {
            //找到删除的节点
            
            if (root.left == null){
                //左子树为空，直接返回右子树作为根节点
                return root.right;
            }else if (root.right == null){
                //返回左子树的节点
                return root.left;
            }else {
                //左右子树都在的情况 1.进入左子树 2.找到最右结点，即直接前驱 3.改变位置

                //找到直接前驱的位置，直接前驱的右子树必为空子树，或者左右均空
                TreeNode rightNode = findRight(root.left);
                //改变节点位置
                rightNode.left = deleteMin(root.left);
                rightNode.right = root.right;
                return rightNode;
            }

        }
    }

    /***
     * 直接前驱节点重连,通过递归，将直接前驱的左子树与root.left重新连接
     * @param node
     * @return
     */
    private TreeNode deleteMin(TreeNode node) {
        if (node.right == null){
            return node.left;
        }
        //节点重新连接
        node.right = deleteMin(node.right);
        return node;
    }

    /***
     * 查找直接前驱的方法 返回值应该是root节点，不应该是空值
     * @param root
     * @return
     */
    private TreeNode findRight(TreeNode root) {
        if (root.right == null){
            return root;
        }
        return findRight(root.right);
    }
}
