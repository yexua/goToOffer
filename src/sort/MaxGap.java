package sort;

/**
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N),且要求不能用非基于比较的排序
 */
public class MaxGap {
    public static void main(String[] args) {
        int[] arr = {12,6,1,5,10,4,9,14};
        System.out.println(maxGap(arr));
    }
    public static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid;
        for (int i = 0; i < len; i++) {
            // 确定当前数属于几号桶
            bid = bucket(arr[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for(; i <= len; i++){
            if(hasNum[i]){
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    private static int bucket(long i, long len, long min, long max) {

        return (int) ((i - min) * len / (max - min));
    }
}
