public class Factorial {
    
    private static int calcFactorial(int n){
        if(n == 0){
            return 1;
        }

        return n*calcFactorial(n-1);
    }
    public static void main(String[] args) {
        int n = 5;

       int res =  calcFactorial(n);
       System.out.println(res);
    }
}
