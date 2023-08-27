public class __8SumOfTwoArray {
    
    public static void calculateSum(int a[], int b[]){
        int sum = 0;
        int i = a.length-1;
        int j = b.length-1;
        int resSize;
        if(i>j){
            resSize = i;
        }else{
            resSize = j;
        }
        int res[] = new int[resSize+1];
        int k = 0;
        while(i>=0 && j>=0){
           sum += a[i] + b[j];
            i--;
            j--;
            res[k] = sum;
            sum = 0;
            k++;
        }
        while(j>=0){
            System.out.println(j);
            res[k] = b[j];
            k++;
            j--;
        }
        while(i>=0){
            res[k] = a[i];
            k++;
            i--;
        }
        for(int x=0; x<res.length; x++){
            System.out.print(res[x]+" ");
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {2,4,6,2,3,2,0,4};
        calculateSum(a,b);
    }
}
