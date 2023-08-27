import java.net.SocketTimeoutException;
import java.util.*;

public class __2InsertAtIndex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the array : ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        int idx;
        int newVal;
        System.out.println("Enter values : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Your array is");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("Enter the index where you want to add new value : ");
        idx = sc.nextInt();
        System.out.println("Enter new value that you want to add ");
        newVal = sc.nextInt();
        int brr[] = new int[arr.length + 1];
        for (int i = 0; i < brr.length; i++) {
            if(i<idx){            // 1 2 3 4 5
                brr[i] = arr[i];  // 1 2
            }else if(i == idx){
                brr[i] = newVal;   // 3 
            }else{
                brr[i] = arr[i-1];
            }
        }
        System.out.println("Your new array is ");
        for(int i=0;i<brr.length; i++){
            System.out.print(brr[i]+" ");
        }
    }
}
