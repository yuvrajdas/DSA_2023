public class __5FindLastOccurance {
    static int res;
    public static void findFirstOccurance(int arr[], int idx, int val){
        if(arr.length == idx) return;
        
        if(arr[idx] == val) res = idx;
        findFirstOccurance(arr, idx+1, val);
    }
    public static void main(String[] args) {
        int arr[] = {2,3,9,8,7,6,4,12,7,3,8};
        findFirstOccurance(arr, 0, 8);
        System.out.println(res);
    }
    
}
