package leetcode.doublepointer;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        boolean isDelete = false;
        while (i < j) {
            if(s.charAt(i) != s.charAt(j)){
                return isPalindrome(s,i + 1,j) || isPalindrome(s, i, j-1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
