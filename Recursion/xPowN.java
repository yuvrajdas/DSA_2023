public class xPowN {
    
    public static int calXPowN(int x, int n){
        if(n == 0){
            return 1;
        }

        int xm1 =calXPowN(x, n-1);
        int xn = x*xm1;
        return xn;
    }
    public static void main(String[] args) {
        int n = 12;
        int x = 5;
        int res = calXPowN(x, n);
        System.out.println(res);

        System.out.println((int)Math.pow(5, 12));
    }
}
