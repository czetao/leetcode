package sort;

import java.util.concurrent.CompletableFuture;

/**
 * 2023/2/14
 * czetao
 * Description 快排
 **/
public class QuickSort {

    private static void quickSout(int[] data, int start, int end) {
        if (start < end) {
            int sort = sort(data, start, end);

            quickSout(data, start, sort - 1);
            quickSout(data, sort + 1, end);
        }
    }

    private static int sort(int[] data, int start, int end) {
        int temp = data[start];
        while (start < end) {
            // 从左往右 找小于temp
            while (start < end && data[end] > temp) {
                end--;
            }
            if (start < end) {
                data[start++] = data[end];
            }
            while (start < end && data[start] <= temp) {
                start++;
            }
            if (start < end) {
                data[end--] = data[start];
            }
        }
        data[start] = temp;
        return start;
    }

    public static void main(String[] args) {
        int[] data = {4, 1, 6, 72, 1};
        quickSout(data, 0, 4);
        for (int datum : data) {
            System.out.println(datum);
        }
    }


}
