package labuladuo.回溯.子集;

/**
 * @description 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * @author chenzetao
 * @time 2024/3/20 17:15
 */

import java.util.LinkedList;
import java.util.List;

public class Combine {

    List<List<Integer>> all;

    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        all = new LinkedList<>();


        backTrack(1, n, k);

        return all;
    }

    private void backTrack(int start, int n, int k) {
        if (path.size() == k) {
            all.add(new LinkedList<>(path));
            return;
        }
        // i = start 保证取的元素都是在数组之后的元素取, 避免重复
        for (int i = start; i <= n; i++) {
            path.add(i);
            // 往树的下一个节点走 startIndex 是个常量, i 是个变量 在 (startIndex, n) 之间
            backTrack(i + 1, n, k);
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> combine1 = combine.combine(3, 2);
        System.out.println(combine1.toString());
    }
}
