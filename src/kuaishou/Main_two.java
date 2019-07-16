package kuaishou;

import java.util.*;

public class Main_two {
    /*给定两个-100到100的整数 x和y ，对x只能加1，-1，*2
    问最少对x进行几次操作能得到y
    用广度优先算法解决！
    1. 用一个数组存放步数
    2. 遍历每一种情况 ， 用队列存放 ， 按顺序进队列，出队列 判断进队列的因素 ，将已经在步数上走过的，就不再走一次，排除重复元素。
    */
    // 3  16
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String[] b = a.split(",");
        int num1 = Integer.parseInt(b[0]); //
        int num2 = Integer.parseInt(b[1]);

        int[] index = new int[1000000];
        Queue<Integer> queue = new LinkedList<>();
        index[num1] = 1;
        int n =1,m=0 ;
        queue.add(num1);
        while(!queue.isEmpty()){
            num1 = queue.poll();
            if(num1 == num2){
                 m = index[num1] ;
                break;
            }
            if(num1 +1 <num2 && index[num1+1] ==0){

                queue.add(num1+1);
                index[num1+1] = n++;

            }
            if(num1 -1 <num2 && index[num1-1] == 0 ){

                queue.add(num1-1);
                index[num1-1] = n++;
            }
            if(num1 *2 <num2 && index[num1*2] ==0){

                queue.add(num1*2);
                index[num1+1] = n++;
            }

        }
        System.out.println(m);


        }

    }

