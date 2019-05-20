/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * 注：不修改原有数组
 */
public class DuplicateArrayNoEdit {
    public static int duplicate(int numbers[],int length,int [] duplication) {
        int start = 1;
        int end = numbers.length;
        while(end >= start){
            int mid = ((end-start) >> 1) + start;
            int count = countRange(numbers,numbers.length, start, mid);
            if(end == start){
                if(count > 1){
                    return start;
                }else{
                    break;
                }
            }
            if(count > (mid-start + 1)){
                end = mid;
            }else{
                start = mid +1;
            }
        }
        return -1;
    }

    private static int countRange(int[] numbers, int length, int start, int end) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if(numbers[i] >= start && numbers[i] <=end){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2};
        System.out.println(duplicate(arr, arr.length, new int[1]));
    }
}
