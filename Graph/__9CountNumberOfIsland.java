package Graph;

public class __9CountNumberOfIsland {

   public static void drawTree(int grid[][], boolean visited[][], int i, int j){
      if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] || grid[i][j] == 0){
         return;
      }
      
      visited[i][j] = true;
      
      drawTree(grid, visited, i+1, j);
      drawTree(grid, visited, i-1, j);
      drawTree(grid, visited, i, j+1);
      drawTree(grid, visited, i, j-1);
   }
   public static int countNoOfIsland(int grid[][]){
      boolean visited[][] = new boolean[grid.length][grid[0].length];
      int count = 0;
      for(int i=0; i<grid.length; i++){
         for(int j=0; j<grid[i].length; j++){
            if(!visited[i][j] && grid[i][j] == 1){
               drawTree(grid, visited, i, j);
               count++;
            }
         }
      }
      return count;
   }

   public static void main(String[] args) {
      int[][] grid = {
         {1, 1, 0, 0, 0},
         {1, 1, 0, 0, 0},
         {0, 0, 1, 0, 0},
         {0, 0, 0, 1, 1}
     };

     int noOfIland = countNoOfIsland(grid);
     System.out.println(noOfIland);
   }

}
