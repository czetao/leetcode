package stack;

import java.util.Scanner;

/***
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 */
public class DFS {
    /**
     * dbf经典算法
     *
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                count++;
                dfs(grid,i,j);
            }
        }
        return count;

    }
    /**
     * dfs找出所有的子节点
     * 将属于同一个小岛的范围都改为0
     */

    public void dfs(char[][] grid,int i,int j){
        grid[i][j]='0';
        //递归遍历其他所有节点
        if(grid[i-1][j]=='1' && i>0){
            dfs(grid,i-1,j);
        }
        if(grid[i][j+1]=='1' && j<grid[i].length){
            dfs(grid,i,j+1);
        }
        if(grid[i+1][j]=='1' && i<grid.length){
            dfs(grid,i+1,j);
        }
        if(grid[i][j-1]=='1' && j>0){
            dfs(grid,i,j-1);
        }
    }


}
