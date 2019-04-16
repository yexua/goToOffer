package sort;

import java.util.Arrays;

public class MergeSort {
        public static void mergeSort(int[] arr){
            if(arr == null || arr.length < 2){
                return;
            }
            mergeSort(arr, 0, arr.length - 1);
        }

        private static void mergeSort(int[] arr, int left, int right){
            if(left == right){
                return;
            }
            int mid = left + ((right-left) >> 1); // <-->  (l+r)/2
            mergeSort(arr, left, mid); // T(n/2)
            mergeSort(arr, mid + 1, right); // T(n/2)
            // left - mid   mid+1 - right 两个序列已经排好序，但整体无序
            // merge的过程就是将两个序列排序
            merge(arr, left, mid, right); // O(n)
            // T(n) = 2T(n/2) + O(n)
        }

        private static void merge(int[] arr, int left, int m, int right) {
            // 申请辅助数组,存放合并后的序列
            int[] help = new int[right - left + 1];
            int i= 0;
            int p1 = left;
            int p2 = m + 1;
            while(p1 <= m && p2 <= right){
                help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            }
            // 越界处理
            while (p1 <= m) {
                help[i++] = arr[p1++];
            }
            while (p2 <= right) {
                help[i++] = arr[p2++];
            }
            for (i = 0; i < help.length; i++) {
                arr[left + i] = help[i];
            }
        }

    public static void main(String[] args) {
        int[] arr = {6,4,3,7,5,1,2};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
