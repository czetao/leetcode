package queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/***
 * bfd :广度优先遍历
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）
 * 使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 */
public class Solution {
    /***
     * 相比于之前，，就是平方 相加
     * 通过开根号，遍历，算出每一个数
     * 也是要找出最短的路径
     * @param n
     * @return
     */
    public int numSquares(int n) {
        Set<Integer> squareSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            //这一步就是bfs中，遍历队列中的所有可能情况并添加到队列中
            for (int i=0;i<size;i++) {
                int now = queue.poll();
                //如果hash集中有相同的，说明是与之相加能得到n,因此返回步数
                if (squareSet.contains(now)) {
                    return step;
                }
                int max = (int)Math.sqrt(now);
                //bfs将所有的可能项，加入到列表当中
                for (int j=max;j>0;j--) {
                    int square = j*j;
                    if (square == now) {
                        return step;
                    } else {
                        if (now == n) {
                            squareSet.add(square);
                        }
                        queue.add(now - square);
                    }
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.numSquares(13));
    }
}
