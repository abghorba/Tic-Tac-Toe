package AI;

import GameBoard.GameBoard;

import java.util.Scanner;

public class Player {
    public GameBoard board;
    public String playerState;
    public String opponentState;

    public Player(GameBoard board, String playerState) {
        this.board = board;
        this.playerState = playerState;

        if (playerState.equals("X"))
            opponentState = "O";
        else if (playerState.equals("O"))
            opponentState = "X";
    }

    /**
     * Checks if the intended move is valid.
     * Protects the user from entering an integer that will cause a array out of bounds.
     * @param row       Row of the board to check.
     * @param col       Column of the board to check.
     * @return          Returns true if move is valid.
     */
    private boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3)
            return false;
        return board.isCellEmpty(row, col);
    }

    /**
     * Uses a Scanner object to take user input.
     * Checks if the intended move is valid.
     * If not valid, user must provide new row and column integers.
     */
    public void makeMove() {
        int row;
        int col;
        Scanner in = new Scanner(System.in);

        System.out.println(playerState + " enter the row and column: ");
        do {
            row = in.nextInt()-1;
            col = in.nextInt()-1;
        } while(!isValidMove(row, col));
        board.playerMove(row, col, playerState);
        board.moves++;
        board.printGameBoard();
    }

    /**
     * Returns the name of the object class.
     * @return      Returns "player"
     */
    public String getName() {
        return "Player";
    }
}
