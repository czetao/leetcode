package HashSet;

import java.util.HashMap;
import java.util.Map;

/***
 *  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Demo3 {
    /**
     * 数据存放map里面，value做key,下标做value
     * 主要思想是通过targe-key
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] tar = new int[2];
        for (int i= 0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++){
            int j = nums[i];
            tar[0] = i;
            int d = target - j;
            if (map.containsKey(d)){
                if( map.get(d)!=i){
                    tar[1] = map.get(d);
                    break;
                }


            }
        }

        return tar;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        Demo3 d = new Demo3();
        int[] ints = d.twoSum(nums, 6);
        for (int l :ints){
            System.out.println(l);
        }
    }
}
