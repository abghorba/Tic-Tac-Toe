package TicTacToe;

import AI.MiniMaxComputer;
import AI.Player;
import GameBoard.GameBoard;

import java.util.Scanner;

public class MinimaxTicTacToe {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        GameBoard board = new GameBoard();

        System.out.println("Do you want to be X or O? (X/O)");
        String mark = in.next();

        Player player = new Player(board, mark);
        MiniMaxComputer computer = new MiniMaxComputer(board, player.opponentState);

        Game game = new Game(board, player, computer);

        game.playGame();
    }
}
