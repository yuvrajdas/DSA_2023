public class __2PrintArrayReverseOrderUsingRecursion {
    
    public static void printArray(int arr[], int idx){
        if(arr.length == idx){
            return;
        }

        printArray(arr, idx+1);
        System.out.print(arr[idx]+" ");
    }
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50};
        printArray(arr, 0);
    }
}
