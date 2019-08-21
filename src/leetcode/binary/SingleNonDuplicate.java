package leetcode.binary;

/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 */
public class SingleNonDuplicate {
    public static void main(String[] args) {
        SingleNonDuplicate s = new SingleNonDuplicate();
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        s.singleNonDuplicate(arr);
    }
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }
}
