package sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 1, 4, 7};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxBits(arr));
    }

    private static void radixSort(int[] arr, int begin, int end, int digit) {
        int radix = 10;
        // 记录每个桶中，实际存放了多少个数据
        int[] count = new int[radix];
        int[][] bucket = new int[radix][arr.length];
        for (int i = 0, n = 1; i < digit; i++, n *= 10) {
            for (int anArr : arr) {
                int digitOfElement = anArr / n % 10;
                //放入对应的桶中
                bucket[digitOfElement][count[digitOfElement]] = anArr;
                //放入一个值，计数加1
                count[digitOfElement]++;
            }
            int index = 0;
            //遍历桶
            for (int k = 0; k < count.length; k++) {
                //判断桶中是否有值
                if (count[k] != 0) {
                    //循环该桶
                    for (int l = 0; l < count[k]; l++) {
                        //取出元素放入原数组
                        arr[index++] = bucket[k][l];
                    }
                }
                //重置该桶
                count[k] = 0;
            }
        }
    }

    /**
     * 获取最大位数
     *
     * @param arr
     * @return
     */
    private static int maxBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }
}
