package previous.offer.ThirdDay;

import java.util.HashMap;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/18 16:12
 * @Description: 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i), ++time);
            }
            else {
                map.put(str.charAt(i), 1);
            }
        }
        int pos = -1;
        int i=0;
        for(;i<str.length();i++){
            char c = str.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return pos;
     }
}
