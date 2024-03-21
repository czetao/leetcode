package previous;

import java.util.Scanner;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        int[] tag=new int[1000000+1];
        for(int i=0;i<n;i++)
        {
            a[i]=in.nextInt();
            tag[a[i]]=1;
        }
        Arrays.sort(a);
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    int temp=a[i]*a[k]*a[j];
                    if(temp>a[n-1])
                    {
                        break;
                    }
                    else if(tag[temp]==1)
                    {
                        count+=1;
                    }
                }
            }
        }
        System.out.println(count);
    }

}