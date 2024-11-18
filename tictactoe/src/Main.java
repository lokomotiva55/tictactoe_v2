import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        char another;
        Scanner sc = new Scanner(System.in);
        do{Game game = new Game();
        game.play();
        System.out.print("Do you want to play again? (Enter y/n): ");
        another = sc.next().charAt(0);}while(another == 'y');
    }
}