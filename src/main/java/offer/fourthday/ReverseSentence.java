package offer.fourthday;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/19 11:06
 * @Description: 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence {
    /**
     * 先反转整个句子，在逐个反转里面的单词
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        char[] c =str.toCharArray();
        int start = 0;
        int end = c.length-1;
        reverse(c,start,end);
        int s = -1;
        for (int i =0;i<c.length;i++){
            if (c[i] == ' ' ){
                reverse(c,s+1,i-1);
                s = i;
            }
            //排除最后一个
            if ( i==c.length-1){
                reverse(c,s+1,i);
            }
        }
        return String.valueOf(c);
    }

    private void reverse(char[] c, int start, int end) {
        for (int i=start,j=end;i<j;i++,j--){
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseSentence g= new ReverseSentence();

        System.out.println( g.ReverseSentence("student. a am I"));
    }
}
