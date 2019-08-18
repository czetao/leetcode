package Summary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/***
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * 最后返回经过上色渲染后的图像。
 * 示例 1:
 * 输入:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 */
public class Demo2 {
    /***
     * 很明显是一道用DFS的题目，类似于岛屿个数。注意newColor与原来颜色一样的情况，因此使用一个arrived数组来标定该节点是否已经被处理过。
     * dfs 基本思想
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] arrived = new int[image.length][image[0].length];
        int val = image[sr][sc];
        grapDfs(image,arrived,sr,sc,newColor,val);
        return image;
    }
    public void grapDfs(int[][] image,int[][] arrived,int sr,int sc,int newColor,int val){
        if(sr <0 || sr>=image.length ||sc<0||sc>=image[0].length){
            return;
        }
        if(image[sr][sc] == val && arrived[sr][sc] ==0) {
            image[sr][sc] = newColor;
            arrived[sr][sc] = 1;
            grapDfs(image,arrived,sr+1,sc,newColor,val);
            grapDfs(image,arrived,sr-1,sc,newColor,val);
            grapDfs(image,arrived,sr,sc+1,newColor,val);
            grapDfs(image,arrived,sr,sc-1,newColor,val);
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        List l = new ArrayList();

    }
}
