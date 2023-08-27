public class __5InverseOfNumber {

    public static void main(String[] args) {
        int no = 12;
        int inv = 0;
        int op = 1;
        while (no != 0) {
            int od = no % 10;
            int id = op;
            int ip = od;
            inv = inv + id * (int) Math.pow(10, ip - 1);
            no = no / 10;
            op++;
        }
        System.out.println(inv);
    }
}
