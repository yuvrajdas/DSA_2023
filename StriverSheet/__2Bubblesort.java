import java.util.Arrays;

public class __2Bubblesort {
    
    private static void bubbleSort(int arr[]){

        for(int i=0; i<arr.length; i++){

            for(int j=0; j<arr.length-1-i; j++){

                if(arr[j]>=arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int arr[] = {2,4,1,0,5,8};
        bubbleSort(arr);
    }
}
