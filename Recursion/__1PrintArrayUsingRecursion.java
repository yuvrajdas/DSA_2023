public class __1PrintArrayUsingRecursion{

    public static void printArray(int arr[], int idx){
        if(idx == arr.length){
            return;
        }
        System.out.print(arr[idx]+" ");
        printArray(arr, idx+1);
    }

    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50};
        printArray(arr, 0);    
    }
}