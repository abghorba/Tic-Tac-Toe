package TicTacToe;

import AI.Player;
import GameBoard.GameBoard;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        GameBoard board = new GameBoard();

        System.out.println("Player 1: Do you want to be X or O? (X/O)");
        String mark = in.next();

        Player player1 = new Player(board, mark);
        Player player2 = new Player(board, player1.opponentState);

        Game game = new Game(board, player1, player2);

        game.playGame();
    }
}
