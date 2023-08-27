import java.util.*;

public class __1PrintFibonacci {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int a = 0;
        int b =1;
        int c = 0;
        while(no!=0){
            System.out.print(a+" ");
            c = a+b;
            a = b;
            b = c;
            no--;
        }
    }
}
 
