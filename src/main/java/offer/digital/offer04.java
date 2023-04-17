package offer.digital;

/**
 * 2023/2/21
 * czetao
 * Description 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class offer04 {

    /**
     * z字型查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberInDArray(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }

    public static  boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }

        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target){
                return true;
            }
            if (matrix[x][y] > target){
                y--;
            }else {
                x++;
            }
        }
        return false;
    }


    /**
     * 替换空格
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        int length = s.length();
        char[] chars = new char[length*3];
        int size = 0 ;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' '){
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            }else {
                chars[size++] = c;
            }
        }
        return new String(chars,0,size);
    }

    public static void main(String[] args) {
        int[][] nums = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,2},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(findNumberIn2DArray(nums, 5));
    }
}
