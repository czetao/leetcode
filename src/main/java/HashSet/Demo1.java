package HashSet;

import java.util.HashSet;
import java.util.Set;

/***
 * 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 */
public class Demo1 {
    public boolean containsDuplicate(int[] nums) {
        //Set<Integer> set = new HashSet<>();
        /*for (int i :nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }

        return false;*/
        int a=0;
        if(nums.length ==1){
            return false;
        }
        //使用异或解决算法，如果有两个数使相同的，则为0，就可以返回true
        for(int i:nums){

            a=a^i;
            if(a==0){
                return true;
        }}

        return false;
    }



}
