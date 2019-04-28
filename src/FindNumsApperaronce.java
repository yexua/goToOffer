/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * //将num1[0],num2[0]设置为返回结果
 */
public class FindNumsApperaronce {
    public static void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if(array == null || array.length <= 2){
            return;
        }

        int resultExOR = 0;
        for(int i=0; i < array.length; ++i){
            resultExOR ^= array[i];
        }
        System.out.println(resultExOR);

    }

    public static void main(String[] args) {
        int[] arr = {2,4,3,6,3,2,5,5};
        findNumsAppearOnce(arr, new int[1], new int[1]);
    }
}
