import java.util.Scanner;

public class UnbeatableTTT
{
    public static void main(String args[])
    {
        int row;
        int col;
        String winner = "";
        boolean keepPlaying = true;


        GameBoard board = new GameBoard();
        Player player = new Player(board, "X");
        Computer computer = new Computer(board, "O");

        Scanner in = new Scanner(System.in);

        board.printGameBoard();

        while(keepPlaying)
        {

        }
    }
}
