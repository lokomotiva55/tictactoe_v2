public class Board {
    int[][] grid = new int[3][3];


    public void printGrid(Player p1, Player p2) {
        for (int k = 0; k < grid.length+ 1; k++){
            System.out.print("———");
        }
        System.out.println("—");
        for (int i = 0; i < grid.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < grid[i].length; j++) {
                int p = grid[i][j];
                if (p == 1){
                    System.out.print(p1.getSymbol() + " | ");
                } else if (p==2) {
                    System.out.print(p2.getSymbol() + " | ");
                }else{
                    System.out.print("  | ");
                }
            }
            System.out.println();
            for (int k = 0; k < grid.length+ 1; k++){
                System.out.print("———");
            }

            System.out.println("—");
        }

    }
}