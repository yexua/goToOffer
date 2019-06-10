import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
class GetLeastNumbers {

    public class Demo{

    }

    public ArrayList<Integer> getLeastNumbers(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || input.length < k || k == 0){
            return list;
        }
        // 优先队列，   逆序排列
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for(int i = 0; i<input.length; i++){
            if(maxHeap.size() !=k){
                //add(E e)和offer(E e)的语义相同，都是向优先队列中插入元素，
                // 只是Queue接口规定二者对插入失败时的处理不同，前者在插入失败时抛出异常，后则则会返回false
                maxHeap.offer(input[i]);
                //element()和peek()的语义完全相同，都是获取但不删除队首元素，也就是队列中权值最小的那个元素，
                // 二者唯一的区别是当方法失败时前者抛出异常，后者返回null
            }else if(maxHeap.peek() > input[i]){
                Integer temp = maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            list.add(integer);
        }
        return list;
    }

    public static void main(String[] args) {
        GetLeastNumbers g = new GetLeastNumbers();
        int[] arr = {4,5,1,6,2,7,3,8};
        System.out.println(g.getLeastNumbers(arr, 4).toString());
        StringBuffer s1=new StringBuffer(10);s1.append("1234");
        System.out.println(s1.length());

        List Listlist1 = new ArrayList();
        Listlist1.add(0);
        List Listlist2 = Listlist1;
        System.out.println(Listlist1.get(0) instanceof Integer);
        System.out.println(Listlist2.get(0) instanceof Integer);

    }
}
