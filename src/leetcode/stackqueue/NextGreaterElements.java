package leetcode.stackqueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 */
public class NextGreaterElements {

    public static void main(String[] args) {
        NextGreaterElements n = new NextGreaterElements();
        int[] a = {5,4,3,2,1};
        System.out.println(0 % 5);
        n.nextGreaterElements(a);
    }

    public int[] nextGreaterElements(int[] nums) {
        final int n = nums.length;
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> pre = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!pre.isEmpty() && nums[pre.peek()] < num) {
                res[pre.pop()] = num;
            }
            if (i < n) {
                pre.push(i);
            }
        }
        return res;
    }
}
