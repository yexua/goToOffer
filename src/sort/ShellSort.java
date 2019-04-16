package sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void shellSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int gap = arr.length >> 1; gap > 0; gap >>= 1){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i = gap; i< arr.length; i++){
                int j = i;
                while(j-gap >= 0 && arr[j] < arr[j-gap]){
                    swap(arr, j, j-gap);
                    j -= gap;
                }
            }

        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,1,6,4,8,7};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
