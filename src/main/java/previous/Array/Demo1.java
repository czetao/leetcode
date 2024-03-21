package previous.Array;

/***
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class Demo1 {

    /**
     * 双指针思想，两指针从头出发，头指针记录前四个元素的位置，尾指针与头指针比较。向后走
     * 1. 相等：头指针不变，尾指针向后走
     * 2. 不等：头指针向后走，尾赋值给头，尾指针向后走
     */
    public int removeDuplicates(int[] nums) {
        int i=0,j=1;
        int length = nums.length;
        for (int d = 0;d<length;d++){
            System.out.println(d);
            if (nums[i] == nums[j]){
                j++;
                if (j==length){

                  break;
                }
            }
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j++];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums =new int[] {0,0,1,2,3};
        Demo1 d = new Demo1();

        System.out.println(d.removeDuplicates(nums));
    }
}
