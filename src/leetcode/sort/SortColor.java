package leetcode.sort;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class SortColor {
    public void sortColors(int[] nums) {
        int i = 0, curr = 0;
        int j = nums.length - 1;
        int temp;
        while (curr <= j) {
            if (nums[curr] == 2) {
                temp = nums[j];
                nums[j--] = nums[curr];
                nums[curr] = temp;
            } else if (nums[curr] == 0) {
                temp = nums[i];
                nums[i++] = nums[curr];
                nums[curr++] = temp;
            } else {
                curr++;
            }
        }
    }

    public static void main(String[] args) {
        SortColor s = new SortColor();
        int[] arr = {2, 0, 2, 1, 1, 0};
        s.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}

