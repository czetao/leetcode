package labuladuo.贪心;

import java.util.Arrays;

/**
 * @author chenzetao
 * @description 设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * <p>
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 * <p>
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 * @time 2024/3/25 09:42
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        // 循环饼干, 匹配一个 --
        // bugfix 遍历胃口
        int result = 0;
        int gLength = g.length - 1;
        int sLength = s.length - 1;

        for (int i = gLength; i >= 0; i--) {
            // bugfix 完全不用while循环

            if (sLength >= 0 && s[sLength] >= g[i]) {
                result++;
                sLength-- ;
            }
//            while (gLength >= 0) {
//                if (s[i] >= g[gLength]) {
//                    result++;
//                    gLength--;
//                    break;
//                }else {
//                    gLength--;
//                }
//            }

        }
        return result;
    }

    public static void main(String[] args) {
        FindContentChildren findContentChildren = new FindContentChildren();
        int contentChildren = findContentChildren.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1});
        System.out.println(contentChildren);
    }
}
