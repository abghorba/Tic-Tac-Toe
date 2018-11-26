package TicTacToe;

import AI.Player;
import GameBoard.GameBoard;

import java.util.Scanner;

public class TicTacToe
{
    public static void main(String args[])
    {
        String winner = "";
        boolean keepPlaying = true;

        Scanner in = new Scanner(System.in);
        GameBoard board = new GameBoard();

        System.out.println("AI.Player 1: Do you want to be X or O? (X/O)");
        String mark = in.next();
        Player player1 = new Player(board, mark);
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

            // AI.Player 1's turn
            player1.makeMove();
            if(board.hasWon(player1.playerState)) {
                winner = player1.playerState;
                continue;
            }
            else if(board.isADraw())
                continue;

            // AI.Player 2's turn
            player2.makeMove();
            if(board.hasWon(player2.playerState)) {
                winner = player2.playerState;
            }
        }
    }
}
