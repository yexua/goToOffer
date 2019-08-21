package sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) { // l == r 则结束递归
            // 随机选定一个值与最后一个值交换作为判定值(随机快排)
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            //swap(arr, l + new Random().nextInt(r - l) + l, r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);  // 对 < x 的区域继续排序
            quickSort(arr, p[1] + 1, r);  // 对 > x 的区域继续排序
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        // 将最后一个值交换到 = x 和 > x 的边界
        swap(arr, more, r);
        // 返回等于区域两个边界的下标值
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 7, 5, 1, 2};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}