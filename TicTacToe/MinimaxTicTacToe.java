package TicTacToe;

import AI.MiniMaxComputer;
import AI.Player;
import GameBoard.GameBoard;

import java.util.Scanner;

public class MinimaxTicTacToe
{
    public static void main(String args[])
    {
        String winner = "";
        boolean keepPlaying = true;

        Scanner in = new Scanner(System.in);
        GameBoard board = new GameBoard();

        System.out.println("Do you want to be X or O? (X/O)");
        String mark = in.next();
        Player player = new Player(board, mark);
        MiniMaxComputer computer = new MiniMaxComputer(board, player.opponentState);


        board.printGameBoard();

        while(keepPlaying) {
            // Determine if game is over and determine the winner, if there is one.
            if(board.isGameOver()) {
                if (board.hasWon(player.playerState) || board.hasWon(computer.playerState))
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

            // AI.Player 1's turn
            player.makeMove();
            if(board.hasWon(player.playerState)) {
                winner = "Player!";
                continue;
            }
            else if(board.isADraw())
                continue;

            // Computer's turn
            computer.makeMove();
            if(board.hasWon(computer.playerState)) {
                winner = "Computer!";
            }
        }
    }
}
