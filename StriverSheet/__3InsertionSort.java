package StriverSheet;

import java.util.Arrays;

public class __3InsertionSort {
    
    private static void insertionSort(int arr[]){

        int n = arr.length;

        for(int i=1; i<n; i++){

            for(int j=i-1; j>=0; j--){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }else{
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int arr[] = {2,4,1,0,5,8};
        insertionSort(arr);
    }
}
