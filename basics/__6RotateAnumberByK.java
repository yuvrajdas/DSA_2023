import java.net.SocketTimeoutException;

class __6RotateAnumberByK {

    public static void main(String[] args) {
        int no = 234567; // after rotation 672345
        int k = 3;
        int divisor = 1;
        int multiplyer = 1;
        int temp = no;
        int count = 1;
        while (temp != 0) {
            if (count <= k) {
                divisor = divisor * 10;
                count++;
            }else{
                multiplyer = multiplyer*10;
            }
            temp = temp/10;
        }
        int rotateAbleDigit = no%divisor;
        int res = (no/divisor)+rotateAbleDigit*multiplyer;
        System.out.println(res);
    }
}