import java.util.Scanner;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/11 19:27
 * @Description:《2048》是一款热门的数字游戏。游戏中，
 * 每个方块上的数字都有2的幂，数字方块会根据指令整体进行上下左右移动，如果两个数字相同的方块在移动中碰撞，
 * 他们就会合成一个新的方块。例如下图为4*4格子的游戏，0表示格子为空，图a为移动前格子中的数字，图b为图a左移后的结果:
 *
 * 0 0 2 4
 * 0 2 2 2
 * 0 4 2 2
 * 8 8 2 2
 *    图a
 * 2 4 0 0
 * 4 2 0 0
 * 4 4 0 0
 * 16 4 0 0
 *    图b
 * 问，给定n*m的矩阵M，0表示空格子，非0整数表示待移动的数字，按照2048的移动规则，输出进行左移操作后的矩阵结果。
 * 输入n行数据
 *
 * 第1行为矩阵行数
 *
 * 第2行到第n行为矩阵每行数据，m个数据用空格隔开
 */
public class XiaoMi {
    static String solution(String[] input) {
        String bigStr =null;
        //每一行开始做
        for (int i=0;i<input.length;i++){
            String str = input[i];
            String newStr =null;
            //分割字符串
            String[] arr = str.split("\\s+");
            for (int j = 0;j<arr.length;j++){
                int num = Integer.parseInt(arr[0]);
                int num2 = Integer.parseInt(arr[1]);
                //如果首行为0，全部左移
                if (num == 0){
                    while(j<str.length()){
                        newStr =newStr+ str.charAt(j+2)+" ";
                        j +=2;
                    }

                }else if(num == num2){
                    num = 2*num;
                    newStr = String.valueOf(num);
                    j +=1;
                    while(j<str.length()){
                        newStr =newStr+ str.charAt(j+2)+" ";
                        j +=2;
                    }
                }

            }
            bigStr = bigStr+newStr;
        }
        return bigStr ;
    }

    /***
     * 楚鸿代码
     * 使用两个辅助数组，对更改后的代码进行重新赋值
     * @param input
     */
    static void solution2(String[] input) {
        int len = input.length;
        for(int i = 0;i<len;i++){
            String[] ch = input[i].split(" ");
            int len1 = ch.length;
            //使用两个数组进行数值的更替
            int[] num = new int[len1];
            int[] tmp = new int[len1];
            int x = 0;
            boolean flag = false;//判断前面的数值是否可以合成
            for(int j=0;j<ch.length;j++){
                num[j] = Integer.valueOf(ch[j]);
                if(num[j]!=0){
                    if(x>0&&num[j]==tmp[x-1]&&flag){
                        tmp[x-1]=2*tmp[x-1];
                        flag = false;
                    }else{
                        tmp[x] = num[j];
                        x++;
                        flag = true;
                    }
                }
            }
            for(int d : tmp){
                System.out.print(d+" ");
            }
            System.out.println();

        }

    }
    public static void main(String[] args){
        /*Scanner in = new Scanner(System.in);
        String res;

        int _input_size = 0;
        //输入的行数
        _input_size = Integer.parseInt(in.nextLine().trim());
        //String[]存所有数据
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        res = solution(_input);
        System.out.println(res);*/
        String[] input={"0 2 2 4","2 2 2 2","0 4 2 2","8 8 2 2"};
        solution2(input);
    }
}
