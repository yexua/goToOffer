public class Demo {
    public static void main(String[] args) {
        int x = 5; int y = 437;
        int temp = 0;
        if(x == y){
            System.out.println(temp);
        }else if(x > y){
            x -= 1;
            temp ++;
        }else{
            while(x != y){
                if(y-x >= x){
                    x *= 2;
					temp ++;
                }else{
                    if(x*2 -y + 1 < y -x){
                        temp += x*2 - y + 1;
                        break;
                    }else{
						x += 1;
                        temp++;
                    }
                }
			
            }
        }
        System.out.println(temp);
    }
}
