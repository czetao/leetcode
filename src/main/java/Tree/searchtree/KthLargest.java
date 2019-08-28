package Tree.searchtree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/24 10:24
 * @Description:
 */
class KthLargest {
    class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    TreeNode root = null;
    List<Integer> list = new ArrayList<>();
    //插入树。返回新增后的根节点
    public TreeNode insertNode(TreeNode root,int val){
        if(root == null){
            return root;
        }
        //小于，往左走
        if(root.val > val){
            root.left = insertNode(root.left,val);
        }else if (root.val < val){
            root.right = insertNode(root.right,val);
        }
        return root;
    }

    //中序遍历二叉搜索树
    public List<Integer> findAll(TreeNode root){
        if(root == null){
            return null;
        }
        findAll(root.left);
        list.add(root.val);
        findAll(root.right);

        return list;
    }

    public KthLargest(int k, int[] nums) {
        root = new TreeNode(nums[0]);
        for (int i =1;i<nums.length;i++){
            insertNode(root,nums[i]);
        }
    }

    //中序遍历，得到第k大
    public int add(int val) {
        insertNode(root,val);
        List<Integer> list = findAll(root);
        return list.get(3);
    }


}
