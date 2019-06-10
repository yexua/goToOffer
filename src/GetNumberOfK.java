/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    public static int GetNumberOfK(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        int mid = (start + end) >> 1;
        int length = array.length;
        while(start <= end){
            if(array[mid] > k){
                end = mid-1;
            }else if(array[mid] < k){
                start = mid+1;
            }else if(mid+1 < length && array[mid+1] == k){
                start = mid+1;
            }else{
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }

    public int GetNumberOfK_2(int[] array, int k) {
        if(array == null || array.length <=0){
            return 0;
        }
        return binarySearch(array, k) - binarySearch(array, k-1);
    }
    private int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(arr[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr  = {1,2,2,3,4};
        GetNumberOfK g = new GetNumberOfK();
        System.out.println(g.GetNumberOfK_2(arr, 2));
    }
}
