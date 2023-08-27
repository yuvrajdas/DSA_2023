import java.util.*;

public class __1ArrayCreation{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the Array :-");
        int size =sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter Array values :- ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Array is ");
        for(int i=0; i <arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}