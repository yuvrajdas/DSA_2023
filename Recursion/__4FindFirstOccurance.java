public class __4FindFirstOccurance {

    static int res;
    public static void findFirstOccurance(int arr[], int idx, int val){
        if(arr.length == idx) return;
        
        findFirstOccurance(arr, idx+1, val);
        if(arr[idx] == val) res = idx;
    }
    public static void main(String[] args) {
        int arr[] = {2,3,9,8,7,6,4,12,7,3,8};
        findFirstOccurance(arr, 0, 8);
        System.out.println(res);
    }
}
