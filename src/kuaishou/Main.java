package kuaishou;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        1 . 先求N 的阶乘 ， 将结果放在一个数组里面
        如何将结果放在一个数组里面 ，这是一个问题 ，一个int类型 ，如何存入数组，将其取余
        不必存放进数组里面， 直接取余 ，判断余数即可
        2. 对数组进行判断 ， 输出第一个0 的前一个数字
         */
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();

        //long sum = a;//记录总数
        Long sum = new Long(a);
        while (--a != 0) {
            sum = sum * a;
        }
        System.out.println(sum);
        //System.out.prlongln(sum);
        while (sum != 0) {
            long b = sum % 10;
            sum = sum / 10;
            if (b != 0) {

                System.out.println(b);
                break;
            }
        }

    }
}

