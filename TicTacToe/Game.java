package TicTacToe;

import AI.Player;
import GameBoard.GameBoard;

import java.util.Scanner;

public class Game {
    private GameBoard board;
    private Player player1;
    private Player player2;

    /**
     * Constructs the Game to play. Uses inheritance to support that player2 can be either
     * an AlphaBetaComputer or a MiniMaxComputer object.
     * @param board         Game board to play.
     * @param player1       Player 1.
     * @param player2       Player 2. Can be either a human or computer.
     *
     * */
    public Game(GameBoard board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Plays the game of Tic Tac Toe.
     * Uses polymorphism to determine the correct makeMove method to run.
     * */
    public void playGame() {
        String winner = "";
        boolean keepPlaying = true;

        Scanner in = new Scanner(System.in);

        board.printGameBoard();

        while(keepPlaying) {
            if(board.isGameOver()) { // Determine if game is over and determine the winner, if there is one.
                if (board.hasWon(player1.playerState) || board.hasWon(player2.playerState))
                    System.out.println(String.format("The winner is: %s!", winner));
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
            player1.makeMove();
            if(board.hasWon(player1.playerState)) {
                winner = player1.getName();
                continue;
            }
            else if(board.isADraw())
                continue;

            // Player 2's turn
            player2.makeMove();
            if(board.hasWon(player2.playerState)) {
                winner = player2.getName();
            }
        }
    }
}