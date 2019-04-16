package sort;

import java.util.Arrays;

/**
 * 折半插入排序
 */
public class BinsertSort {
    public static void binsertSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int low = 0, high = i-1, tmp = arr[i];
            while(low <= high){
                int mid = (low + high) / 2;
                if(arr[mid] > tmp){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            for(int j = i -1; j >= high + 1; j--){
                arr[j + 1] = arr[j];
            }
            arr[high+1] = tmp;
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,1,6,4,8,7};
        binsertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
