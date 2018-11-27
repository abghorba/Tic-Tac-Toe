package TicTacToe;

import AI.AlphaBetaComputer;
import AI.Player;
import GameBoard.GameBoard;

import java.util.Scanner;

public class AlphaBetaTicTacToe {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        GameBoard board = new GameBoard();

        System.out.println("Do you want to be X or O? (X/O)");
        String mark = in.next();

        Player player = new Player(board, mark);
        AlphaBetaComputer computer = new AlphaBetaComputer(board, player.opponentState);

        Game game = new Game(board, player, computer);

        game.playGame();
    }
}
