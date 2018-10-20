import java.util.Scanner;

public class TicTacToe
{
    public static void main(String args[])
    {
        int row;
        int col;
        String winner = "";
        boolean keepPlaying = true;

        Scanner in = new Scanner(System.in);
        GameBoard board = new GameBoard();

        System.out.println("Player 1: Do you want to be X or O? (X/O)");
        String player1Mark = in.next();
        Player player1 = new Player(board, player1Mark);
        Player player2 = new Player(board, player1.opponentState);

        board.printGameBoard();

        while(keepPlaying) {
            // Check if the game is over and determine a winner, if there is one.
            if(board.isGameOver()) {
                if (board.hasWon(player1.playerState) || board.hasWon(player2.playerState))
                    System.out.println("The winner is: " + winner);
                else if (board.isADraw())
                    System.out.println("Its a DRAW!");

                System.out.print("Do you want to play again? (y/n)");
                String playAgain = in.next();
                if (playAgain.equals("y")) {
                    System.out.println("");
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
            if(board.hasWon(player1.playerState)) {
                winner = "Player 1";
                continue;
            }
            else if(board.isADraw())
                continue;

            // Player 2's turn
            System.out.print("Player 2 enter the row and column: ");
            do {
                row = in.nextInt()-1;
                col = in.nextInt()-1;
            } while(!player2.isValidMove(row, col));
            player2.makeMove(row, col);
            board.moves++;
            board.printGameBoard();
            if(board.hasWon(player2.playerState)) {
                winner = "Player 2";
                continue;
            }
            else if(board.isADraw())
                continue;
        }
    }
}
