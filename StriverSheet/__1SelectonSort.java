import java.util.Arrays;

public class __1SelectonSort {
    
    private static void selectionSort(int arr[]){

        for(int i=0; i<arr.length; i++){

            for(int j = i+1; j<arr.length; j++){
                if(arr[i]>=arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int arr[] = {1,2,6,4,8,0,3};
        selectionSort(arr);
    }    
}
