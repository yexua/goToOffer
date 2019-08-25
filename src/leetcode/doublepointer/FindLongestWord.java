package leetcode.doublepointer;

import java.util.List;

/**
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，
 * 该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，
 * 返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * 示例 1:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * 输出:
 * "apple"
 * 示例 2:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 * <p>
 * 输出:
 * "a"
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 */
public class FindLongestWord {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int i = longestWord.length(), j = target.length();
            if (i > j || (i == j && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubStr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    private boolean isSubStr(String s, String target) {
//        int i = 0, j = 0;
//        while (i < s.length() && j < target.length()) {
//            if (s.charAt(i) == target.charAt(j)) {
//                j++;
//            }
//            i++;
//        }
//        return j == target.length();
        int start = -1;
        for (char c : target.toCharArray()) {
            int index;
            if ((index = s.indexOf(c, start + 1)) == -1) {
                return false;
            }
            start = index;
        }
        return true;
    }
}