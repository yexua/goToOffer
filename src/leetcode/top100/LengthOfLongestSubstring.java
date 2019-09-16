package leetcode.top100;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串的长度。
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        l.lengthOfLongestSubstring("abcabcbb");
    }

    public int lengthOfLongestSubstring(String s) {
        final int n = s.length();
        int ans = 0;
        int[] hash = new int[128];
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(hash[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            hash[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
