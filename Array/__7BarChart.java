public class __7BarChart {
    
    public static void printBarChart(int arr[]){
       int max = arr[0];
       for(int i=1; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
       }
       for(int floor = max; floor>=1; floor--){
            for(int i=0; i<arr.length; i++){
                if(floor<=arr[i]){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[] = {6,3,2,5,8,4};
        printBarChart(arr);
    }
}
