package leetcode.doublepointer;

import java.util.Arrays;
import java.util.List;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 */
public class ReverseStringYuan {
    public String reverseVowels(String s) {
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] result = new char[s.length()];
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char min = s.charAt(i);
            char max = s.charAt(j);
            if (!list.contains(min)) {
                result[i++] = min;
            } else if (!list.contains(max)) {
                result[j--] = max;
            } else {
                result[i++] = max;
                result[j--] = min;
            }
        }
        return new String(result);
    }
}
