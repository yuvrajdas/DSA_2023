
// You have given a number n and digit k find the find total occurance of k in the number n;
public class __1CountFrequencyOfGivenK{
    
    public static void findOccurenceOfK(int n, int k){
        int count =0;
        while(n!=0){
            int rem = n%10;
            if(rem == k){
                count++;
            } 
            n/=10;
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        int n = 224344441;
        int k =4;
        findOccurenceOfK(n, k);
    }
}