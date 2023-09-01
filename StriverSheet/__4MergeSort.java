package StriverSheet;

import java.util.Arrays;

public class __4MergeSort {
    
    public static int[] mergeTwoSortedArray(int arr[], int arr2[]){
        int n1 = arr.length-1;
        int n2 = arr2.length-1;
        int res[] = new int[arr.length+arr2.length];
        int idx1 = 0;
        int idx2 = 0;
        int x = 0;
        while(idx1<=n1 && idx2<=n2){
            if(arr[idx1]<=arr2[idx2]){
                res[x] = arr[idx1];
                idx1++;
                x++;
            }else{
                res[x] = arr2[idx2];
                idx2++;
                x++;
            }
        }   
        while(idx1<=n1){
            res[x] = arr[idx1];
            idx1++;
            x++;
        }

        while(idx2<=n2){
            res[x] = arr2[idx2];
            idx2++;
            x++;
        }
        return res;
    }
    public static int[] mergeSort(int arr[], int si, int ei){
        if(si == ei){
           int ba[] = new int[1];
            ba[0] = arr[si];
            return ba;
        }

        int mid = si+(ei-si)/2;
        int fsh[] =  mergeSort(arr, si, mid);
        int ssh[] =  mergeSort(arr, mid+1,ei);
        return mergeTwoSortedArray(fsh, ssh);
    }
    
    public static void main(String[] args) {
        int arr[] = {1,9,0,11,3,7};
        int res[] = mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(res));
    }

}

