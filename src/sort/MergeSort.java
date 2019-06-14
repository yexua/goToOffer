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
        int[] arr = {364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
