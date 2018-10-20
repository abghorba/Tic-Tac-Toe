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

        while(keepPlaying) {
            if(board.isGameOver()) {
                if (board.isAWin())
                    System.out.println("The winner is: " + winner);
                else if (board.isADraw())
                    System.out.println("Its a DRAW!");

                System.out.print("Do you want to play again? (y/n)");
                String playAgain = in.next();
                if (playAgain.equals("y")) {
                    board.resetGameBoard();
                    board.printGameBoard();
                    continue;
                }
                else {
                    keepPlaying = false;
                    System.out.println("Thanks for playing!");
                    continue;
                }
            }

            // Player 1's turn
            System.out.println("Player 1 enter the row and column: ");
            do {
                row = in.nextInt()-1;
                col = in.nextInt()-1;
            } while(!player1.isValidMove(row, col));
            player1.makeMove(row, col);
            board.moves++;
            board.printGameBoard();
            if(board.isAWin()) {
                winner = "Player 1!";
                continue;
            }
            else if(board.isADraw())
                continue;


            // Computer's turn
            computer.makeMove();
            board.moves++;
            board.printGameBoard();
            if(board.isAWin()) {
                winner = "Computer!";
                continue;
            }
            else if(board.isADraw())
                continue;
        }
    }
}
