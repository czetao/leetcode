package Tree;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/18 15:19
 * @Description: 给定一个数组，其中元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 给定排序数组：[ -10，-3, 0, 5, 9]
 * 一个可能的答案是：[0，-3, 9，-10，null，5]，它代表以下高度平衡的二叉搜索树：
 *         0
 *       /   \
 *
 *    -3     9
 *   /        /
 * -10     5
 */
public class SearchTree {

    /***
     * 可以发现，升序的数组是二叉搜索树的中序遍历，利用中序遍历，给二叉树赋值。中节点则是树的根节点
     * 通过分为3部分，将mid,mid前，mid后，通过递归，为树的每一节点赋值
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return addBST(nums,0,nums.length-1);
    }

    private TreeNode addBST(int[] nums, int i, int length) {
        if (i>length){
            return null;
        }
        int mid = (i+length)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = addBST(nums,i,mid-1);
        root.right =addBST(nums,mid+1,length);
        return root;
    }


}
