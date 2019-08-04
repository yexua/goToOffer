package leetcode.sort;

import java.util.PriorityQueue;

public class FindKthLargest {

    public static void main(String[] args) {
        FindKthLargest f = new FindKthLargest();
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(f.findKthLargest_MyMin(arr, 2));
    }

    /**
     * 利用库函数，PriorityQueue优先队列，默认是小顶堆
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>(k + 1);
        for (int num : nums) {
            min.offer(num);
            if (min.size() > k) {
                min.poll();
            }
        }
        return min.peek();
    }

    /**
     * 手写实现小顶堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest_MyMin(int[] nums, int k) {
        for (int i = (k - 1) / 2; i >= 0; i--) {
            heapify(nums, i, k);
        }

        for (int i = k; i < nums.length; ++i) {
            if (nums[i] > nums[0]) {
                nums[0] = nums[i];
                heapify(nums, 0, k);
            }
        }
        return nums[0];
    }

    private void heapify(int[] nums, int i, int k) {
        int smallestIndex = i;
//        int leftIndex = 2 * i + 1;
        int leftIndex = (i << 1) + 1;
//        int rightIndex = 2 * i + 2;
        int rightIndex = (i << 1) + 2;
        if (leftIndex < k && nums[leftIndex] < nums[smallestIndex]) {
            smallestIndex = leftIndex;
        }
        if (rightIndex < k && nums[rightIndex] < nums[smallestIndex]) {
            smallestIndex = rightIndex;
        }
        if (smallestIndex != i) {
            int tmp = nums[i];
            nums[i] = nums[smallestIndex];
            nums[smallestIndex] = tmp;
            heapify(nums, smallestIndex, k);
        }
    }

    public int findKthLargest_quick(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int index = partition(nums, l, h);
            if (index == k) {
                break;
            } else if (index < k) {
                l = index + 1;
            } else {
                h = index - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] arr, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (arr[++i] < arr[l] && i < h) ;
            while (arr[--j] > arr[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
