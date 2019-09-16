package leetcode.stackqueue;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * ASCII码：
 * ( 40
 * ) 41
 * { 123
 * } 125
 * [ 91
 * ] 93
 */
public class IsValid {
    Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        IsValid i = new IsValid();
        i.isValid("({})");
    }


    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        char[] temp = new char[s.length() / 2 + 1];
        int i = 0, a = 0;
        while (i < s.length()) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                a++;
                temp[a] = chars[i];
            } else if (chars[i] == temp[a] + 1 || chars[i] == temp[a] + 2) {
                a--;
            } else {
                return false;
            }
            i++;
        }
        if (a != 0) {
            return false;
        }
        return true;
    }
}
