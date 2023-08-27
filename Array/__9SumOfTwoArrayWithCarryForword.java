public class __9SumOfTwoArrayWithCarryForword {

    public static void calCulateSum(int arr[], int brr[]){
        int i = arr.length-1;
        int j = brr.length-1;
        int size;
        if(i>j){
            size = i;
        }else{
            size = j;
        }
        int res[] = new int[size+3];
        int k = res.length;
        int carry = 0;
        while(i>=0 && j>=0){
            int sum = arr[i] + brr[j]+carry;
            if(sum>9){
                res[k] =  sum%10;
            }else{
                res[k] = sum;
            }
            carry= sum/10;
            k--;
            i--;
            j--;
            sum =0;
        }
        for(int x=0; x<res.length; x++){
            System.out.print(res[x]+" ");
        }

    }
    public static void main(String[] args) {
        int arr[] = {9,2,3,4,2,8,9,1,7};
        int brr[] = {3,9,1,6,0,8,4,12,3};
        calCulateSum(arr, brr);
    }
}
