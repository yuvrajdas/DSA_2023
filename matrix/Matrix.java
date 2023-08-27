public class Matrix{
    public static void main(String[] args) {
        int mat[][] = {{1,2,3},{5,6,7},{8,9,0}};
    //    1 2 3
    //    5 6 7
    //    8 9 0
        for(int i=0; i<mat.length; i++){
            for(int j=i; j<mat[0].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}