package previous.offer;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/16 11:56
 * @Description: 变态跳台阶
 */
public class JumpFloorII {
    /***
     * 得出最终结论,在n阶台阶，一次有1、2、...n阶的跳的方式时，总得跳法为：
     *
     *               | 1       ,(n=0 )
     *
     * f(n) =     | 1       ,(n=1 )
     *
     *               | 2*f(n-1),(n>=2)
     */
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }
}
