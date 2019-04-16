package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        for(int i = 0; i< arr.length-1; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void bubbleSort_imp(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        boolean flag  = true;
        for(int i = 0; i< arr.length-1 && flag; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                    flag = true;
                }
            }
        }
    }

    public static void swap(int[]arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {4,2,6,7,5,1,8};
        int[] arr2 = {4,2,6,7,5,1,8,2,3,5,6,1,23,5,5,2,123,5,6,32,123,5,64,3,1,21,51,23};
//        bubbleSort(arr1);
        bubbleSort_imp(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
