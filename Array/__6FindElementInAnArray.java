public class __6FindElementInAnArray {
    
    public static int findElementIndex(int arr[], int k){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == k){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 9,5,1};
        int k = 5;
        int res = findElementIndex(arr, k);
        System.out.println(res);
    }
}
