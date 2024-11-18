import java.util.Scanner;
public class Game {
    Board board = new Board();

    public void play() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter player symbol: ");
        char symbol = sc.next().charAt(0);
        Player p1 = new Player(1, symbol);

        System.out.print("Enter player symbol: ");
        symbol = sc.next().charAt(0);
        Player p2 = new Player(2, symbol);
        Player next = p2;
        int count = 0;
        move(p1);
        this.board.printGrid(p1, p2);
        while(count < 8){
            move(next);
            this.board.printGrid(p1, p2);
            if (winCheck(next)){
                System.out.println("Player " + next.getPid() + " won.");
                return;
            }
            if (next == p1){
                next = p2;
            }else{
                next = p1;
            }
            count++;
        }
        System.out.println("Draw");



    }

    public void move(Player p){
        Scanner sc = new Scanner(System.in);
        boolean occupied = false;
        int tx = 8;
        int ty = 8;
        int x;
        int y;
        do {
            while ((tx > 3) || (ty > 3)) {
                System.out.println("Player " + p.getPid());
                System.out.print("Enter X [1-3] Y [1-3] coordinates for your next move: ");
                tx = sc.nextInt();
                ty = sc.nextInt();
            }
            x = 3 - tx;
            y = ty - 1;
            occupied = false;
            if (this.board.grid[x][y] != 0){
                System.out.print("That place is already occupied! \n");
                occupied = true;
                tx = 5;
            }
        }while(occupied);
        this.board.grid[x][y] = p.getPid();
        System.out.println("Your move: \nX: " + tx + " Y: " + ty);

    }

    public boolean winCheck(Player p){
        int pid = p.getPid();
        int counth;
        int countv;
        for (int x = 0; x < 3; x++){
            counth = 0;
            countv = 0;
            for (int y = 0; y < 3; y++){
                if (this.board.grid[x][y] == pid){
                    counth++;
                }
                if (this.board.grid[y][x] == pid){
                    countv++;
                }
            }
            if (counth == 3 || countv == 3){
                return true;
            }
        }
        return (this.board.grid[0][0] == pid && this.board.grid[1][1] == pid && this.board.grid[2][2] == pid) || (this.board.grid[0][2] == pid && this.board.grid[1][1] == pid && this.board.grid[2][0] == pid);
    }
}