package offer.digital;

import java.util.HashMap;
import java.util.Map;

/**
 * 2023/2/22
 * czetao
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 思路
 * <p>
 * 对于任意一颗树而言，前序遍历的形式总是
 * <p>
 * <p>
 * [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
 * 即根节点总是前序遍历中的第一个节点。而中序遍历的形式总是
 * <p>
 * <p>
 * [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
 * 只要我们在中序遍历中定位到根节点，那么我们就可以分别知道左子树和右子树中的节点数目。由于同一颗子树的前序遍历和中序遍历的长度显然是相同的，因此我们就可以对应到前序遍历的结果中，对上述形式中的所有左右括号进行定位。
 * <p>
 * 这样以来，我们就知道了左子树的前序遍历和中序遍历结果，以及右子树的前序遍历和中序遍历结果，我们就可以递归地对构造出左子树和右子树，再将这两颗子树接到根节点的左右位置
 **/
public class offer07 {

    private static Map<Integer, Integer> getMiddler;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode build(int[] preorder, int[] inorder, int preorderLeft, int proorderRight,
                           int inorderLeft, int inorderRight) {

        if (preorderLeft > proorderRight) {
            return null;
        }
        int rootVal = preorder[preorderLeft];
        // 得到根节点 在中序遍历中的坐标
        Integer integer = getMiddler.get(rootVal);
        // 得到左节点数目的个数
        int sumLeft = integer - inorderLeft;
        // 根节点
        TreeNode rootNode = new TreeNode(rootVal);

        rootNode.left = build(preorder, inorder, preorderLeft + 1, preorderLeft + sumLeft, inorderLeft, integer - 1);
        rootNode.right= build(preorder, inorder, preorderLeft + sumLeft + 1,proorderRight, integer + 1, inorderRight);
        return rootNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        getMiddler = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            getMiddler.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);

    }
}
