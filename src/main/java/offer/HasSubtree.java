package offer;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/16 10:54
 * @Description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /***
     * 算法思路 ： 第一步 ：找到root2根节点相同的root1 第二步：判断子结构是否相同。
     * 第一步 ：递归终止条件，root1为空。每一次递归做的事，判断值是否相同。值相同进入第二步
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null){
            return false;
        }
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root1 != null && root2 !=null){
        if (root1.val == root2.val){
            result = DoesTree1HaveTree2(root1,root2);
        }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
        if (!result){
            result = HasSubtree(root1.left,root2);
        }
            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
        if (!result){
            result = HasSubtree(root1.right,root2);
        }}
        return result;
    }

    /***
     * 判断子结构是否符合
     * @param root1
     * @param root2
     * @return
     */
    private boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (root2 == null){
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (root1 == null){
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (root1.val != root2.val){
            return false;
        }
        //如果根节点对应的上，那么就分别去子节点里面匹配
        return DoesTree1HaveTree2(root1.left,root2.left) && DoesTree1HaveTree2(root1.right,root2.right);
    }
}
