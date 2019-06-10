import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class MainStack {

    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public static void main(String[] args) {
        MainStack stack = new MainStack();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        stack.pop();
        stack.pop();
        stack.push(0);
        System.out.println(stack.min());
    }

    public void push(int node) {
        data.push(node);
        if (min.size() == 0 || node < top()) {
            min.push(node);
        } else {
            min.push(top());
        }
    }

    public void pop() {
        if (data.size() > 0 && min.size() > 0) {
            data.pop();
            min.pop();
        }
        System.out.println("栈为空");
    }

    public int top() {
        return min.peek();
    }

    public int min() {
        if (data.size() > 0 && min.size() > 0) {
            return top();
        }
        return -1;
    }
}
