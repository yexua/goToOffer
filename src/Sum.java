/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum {
    private static int a = 10;
    public int sum(int n) {
        int sum = n;
        boolean flag = sum > 0 && (sum += sum(n - 1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        Sum s = new Sum();
        System.out.println(s.sum(10));
    }
}

class HelloWorld {
    private static int x=100;
    public static void main(String args[]){
        HelloWorld hs1=new HelloWorld();
        hs1.x++;
        HelloWorld  hs2=new HelloWorld();
        hs2.x++;
        hs1=new HelloWorld();
        hs1.x++;
        HelloWorld.x--;
        System.out.println("x="+x);
    }
}