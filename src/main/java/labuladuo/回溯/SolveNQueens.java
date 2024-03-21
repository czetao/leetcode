package labuladuo.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenzetao
 * @description 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * @time 2024/3/19 17:18
 */
public class SolveNQueens {

    List<List<String>> all;

    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盘
        all = new LinkedList<>();


        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            board.add(sb.toString());
        }
        backTrack(board, 0);
        return all;
    }

    private void backTrack(List<String> board, int row) {

        if (row == board.size()) {
            all.add(new ArrayList<>(board));
            return;
        }

        for (int i = 0; i < board.size(); i++) {
            if (!isValide(board, row, i)) {
                continue;
            }

            StringBuilder builder = new StringBuilder(board.get(row));
            builder.setCharAt(i, 'Q');
            board.set(row, builder.toString());
            backTrack(board, row + 1);
            builder.setCharAt(i, '.');
            board.set(row, builder.toString());
        }


    }

    // 判断是否符合条件

    /**
     * @description 皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 board 当前行的数据 ,row 行数  i 列数
     * @author chenzetao
     * @time 2024/3/19 17:44
     */
    private boolean isValide(List<String> board, int row, int col) {
        int size = board.size();

        // 检查列
        for (int j = 0; j < size; j++) {
            if (board.get(j).charAt(col) == 'Q') {
                return false;
            }
        }
        // 检查左上角
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // 检查右上角
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < size; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        List<List<String>> lists = solveNQueens.solveNQueens(4);
        System.out.printf(lists.toString());
    }
}
