package leetcode.binary;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 */
public class FindMin {

    public static void main(String[] args) {
        FindMin f = new FindMin();
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        f.findMin(arr);
        f.findMin_(arr);
    }

    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        int count = 0;
        while (l < h) {
            count++;
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        System.out.println("次数："+ count);
        return nums[l];

    }

    public int findMin_(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int count = 0;

        while (left < right) {
            count++;
            mid = (left + right) / 2;

            //nums[mid] >nums[right]  说明nums[mid] 属于前面的数组
            if (nums[mid] > nums[right])
                //可以加1，将查找范围往后推
                left = mid + 1;
            else if (nums[mid] < nums[right])
                //不可以减1, 因为mid可能就是我们要查找的元素
                right = mid;
            else
                --right;  //处理相等情况。
        }
        System.out.println("次数："+ count);
        return nums[left];
    }
}
