public class Player {
    int pid;
    char symbol;
    int wins = 0;

    public Player(int pid, char symbol){
        this.pid = pid;
        this.symbol = symbol;
    }

    public int getPid() {
        return pid;
    }

    public char getSymbol() {
        return symbol;
    }

}