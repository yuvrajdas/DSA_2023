import java.util.Scanner;

public class __2CountDigit {

    public static void main(String[] args) {
        int no = 2394757;
        int count = 0;
        while (no != 0) {
            no = no / 10;
            count++;
        }
        System.out.println(count);
    }
}
