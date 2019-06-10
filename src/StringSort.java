import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *   输入描述:
 *       输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class StringSort {
    public ArrayList<String> permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str.length() == 0){
            return result;
        }
        permutation(str.toCharArray(), 0, result);
        Collections.sort(result);
        return result;
    }
    private void permutation(char[] ch, int i, List<String> list){
        if(i == ch.length - 1){
            // 判断是否重复
            if(!list.contains(new String(ch))){
                list.add(new String(ch));
                return;
            }
        }else{
            for(int j = i; j < ch.length; j++){
                swap(ch, i, j);
                permutation(ch, i+1, list);
                swap(ch, i, j);
            }
        }
    }

    private void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static void main(String[] args) {
        StringSort s = new StringSort();
        System.out.println(s.permutation("abc"));
    }
}
