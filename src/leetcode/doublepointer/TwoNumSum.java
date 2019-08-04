package leetcode.doublepointer;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

 说明:

 返回的下标值（index1 和 index2）不是从零开始的。
 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 */
public class TwoNumSum {
    public int[] twoSum(int[] numbers, int target) {
        int min = 0, max = numbers.length - 1;
        int sum;
        while (min < max) {
            sum = numbers[min] + numbers[max];
            if (sum == target) {
                return new int[]{min + 1, max + 1};
            } else if (sum > target) {
                max--;
            }else{
                min++;
            }
        }
        return null;
    }
}
