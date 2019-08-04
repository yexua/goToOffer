package leetcode.sort;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(nlogn) , n 是数组的大小。
 */
public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent t = new TopKFrequent();
        int[] arr = {1, 1, 1, 2, 2, 3,2,12,4,2,3,4,2,12,3,4,1,32,41,4,5,5,23,12,2,4,123,1,24,23,1
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3
                ,23,2,3,123,12,3,12,3,123,12,3,21,312,32,13,21,3,21,321,312,3};
        System.out.println(t.topKFrequent(arr, 2));
    }

    public List<Integer> topKFrequent_me(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        int[] buckets = new int[nums.length + 1];
        int[] count = new int[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : frequencyForNum.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (buckets[val] == 0) {
            }
        }
        List<Integer> topK = new ArrayList<>();
        return null;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        //因为数字出现频率不可能高于这个数组本身长度,但要注意需包含频率=nums.length,所以这里要+1
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        long s = System.currentTimeMillis();
//        frequencyForNum.forEach((key, val) -> {
//            if (buckets[val] == null) {
//                buckets[val] = new ArrayList<>();
//            }
//            buckets[val].add(key);
//        });

        for (Map.Entry<Integer, Integer> entry : frequencyForNum.entrySet()) {
            int frequency = entry.getValue();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(entry.getKey());
        }

//        for (int key : frequencyForNum.keySet()) {
//            int frequency = frequencyForNum.get(key);
//            if (buckets[frequency] == null) {
//                buckets[frequency] = new ArrayList<>();
//            }
//            buckets[frequency].add(key);
//        }
        System.out.println(System.currentTimeMillis() - s);
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        return topK;
    }

    public List<Integer> topKFrequent_min(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int key : map.keySet()) {
            if (pq.size() < k)
                pq.add(key);
            else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }
}
