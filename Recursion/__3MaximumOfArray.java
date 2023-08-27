public class __3MaximumOfArray {
    static int max = 0;
    public static void findMax(int arr[], int idx){
        if(arr.length == idx) return;
      
        findMax(arr, idx+1);
        max = Math.max(arr[idx], max);
       
    }
    public static void main(String[] args) {
        int arr[] = {10,23,4,5,66,7,88};
        findMax(arr, 0);
        System.out.println(max);
    }
}
