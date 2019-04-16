package sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    public static void selectSort(int[] arr){
        if(arr == null && arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            // 用于存放较小元素的数组下标
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            if(minIndex != i){
                swap(arr, i, minIndex);
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        int[] arr = new int[10000];
        for(int i = 0; i< 10000; i++){
            arr[i] = i;
        }
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
    }
}
