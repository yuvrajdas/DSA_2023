import java.util.ArrayList;

public class __6FindAllOccurance {

    static int i = -1;
    static ArrayList<Integer> list = new ArrayList<>();
    private static void findAllOccurance(int arr[], int idx, int val){
        if(arr.length == idx) return;
        if(arr[idx] == val) list.add(idx);
        findAllOccurance(arr, idx+1, val);
        
    }

    public static void main(String[] args) {
        int arr[] = {2,3,9,8,7,6,3,12,7,3,8};
        findAllOccurance(arr, 0, 3);
        System.out.println(list);
    }
    
}
