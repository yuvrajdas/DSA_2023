public class __3PrintDigitOfNumber {

    public static void main(String[] args) {
        int no = 384756;
        while(no!=0){
            int rem = no%10;
            System.out.print(rem +" ");
            no = no/10;
        }
    }
}
