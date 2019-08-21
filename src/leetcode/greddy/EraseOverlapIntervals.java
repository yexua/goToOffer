package leetcode.greddy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * <p>
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 * <p>
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 */
public class EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
//        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            count++;
        }
        return intervals.length - count;
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了36.70%的用户
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals_(int[][] intervals) {
        sort(intervals);
        int deletenum = 0;
        int pre = intervals.length - 1;
        int step = 1;
        for (int i = intervals.length - 2; i >= 0; i--) {
            if (intervals[pre][0] < intervals[i][1]) {
                deletenum++;
                step++;
            } else {
                pre -= step;
                step = 1;
            }
        }
        return deletenum;
    }

    private void sort(int[][] arrs) {
        for (int i = 1; i < arrs.length; i++) {
            int[] tem = arrs[i];
            int index = i - 1;
            while (index >= 0 && arrs[index][0] >= tem[0]) {
                if (arrs[index][0] == tem[0] && arrs[index][1] <= tem[1]) {
                    break;
                }
                arrs[index + 1] = arrs[index];
                index--;
            }
            arrs[index + 1] = tem;
        }
    }

    public static void main(String[] args) {
        EraseOverlapIntervals e = new EraseOverlapIntervals();
        int[][] a = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        e.eraseOverlapIntervals_(a);
    }
}
