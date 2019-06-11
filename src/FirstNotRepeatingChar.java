/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar {
    public static void main(String[] args) {
        String str = "googgle";
        System.out.println(FirstNotRepeatingChar(str));
    }

    public static int FirstNotRepeatingChar(String str) {
        //运行时间：27ms
        //占用内存：9340k
        char[] chars = str.toCharArray();
//        Map<Character,Integer> map = new HashMap<>();
        int[] hashTable = new int[256];
        int i = 0;
        while (i < chars.length) {
            System.out.println(chars[i]);
            hashTable[chars[i++]]++;
        }
        i = 0;
        while (i < chars.length) {
            if (hashTable[chars[i]] == 1) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
