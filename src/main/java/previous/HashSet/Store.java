package previous.HashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/2 09:24
 * @Description:
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 */
public class Store {

    /***
     * 使用容器，hashset。 先将j中的字符存进set容器中，再判断s是否有字符存在容器中，有的话ans加一
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        Set count = new HashSet();
        for (int i = 0 ; i<J.length();i++){
            count.add(J.charAt(i));
        }
        int ans = 0;
        for (int s = 0; s<S.length();s++){
            if (count.contains(S.charAt(s))){
                ans++;
            }
        }
        return ans;
    }
}
