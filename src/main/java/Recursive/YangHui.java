package Recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/21 15:40
 * @Description: 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */

public class YangHui {
    /***
     * 杨辉三角迭代解法
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

         if(numRows == 0){
             return list;
         }
         list.add(new ArrayList<>());
         list.get(0).add(1);

         for(int i=1 ; i<numRows ;i++){
             List<Integer> l = new ArrayList<>();
             l.add(1);
             for(int j=1;j<i;j++){
             l.add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
                 }

             l.add(1);
             list.add(l);
         }
         return list;
    }

    /***
     * 杨辉三角递归解法
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        if (numRows == 1){
            list.get(0).add(1);

        }else{
        list = generate2(numRows-1);
        for (int j=1;j<numRows;j++){
            l.add(list.get(numRows-1).get(j-1)+list.get(numRows-1).get(j));

        }
        }

        return list;
    }

    private List<List<Integer>> gen(List<List<Integer>> list, int numRows) {
        List<Integer> l = new ArrayList<>();
        if (numRows == 1){
            list.get(0).add(1);
            return list;
        }

        for (int j=1;j<numRows;j++){
            l.add(list.get(numRows-1).get(j-1)+list.get(numRows-1).get(j));

        }
        list.add(l);
        gen(list,numRows--);
        return list;

    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
