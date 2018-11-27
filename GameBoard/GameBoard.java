package GameBoard;

import java.util.ArrayList;
import java.util.List;

public class GameBoard
{
    private final static int ROWS = 3;
    private final static int COLS = 3;
    private final static int MAX_MOVES = 9;

    private Cell[][] board;

    public int moves;

    /**
     * Sets the game board to have all cells with state " ".
     */
    public GameBoard() {
        board = new Cell[ROWS][COLS];

        for(int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = new Cell();
            }
        }
        moves = 0;
    }

    /**
     * Checks if a given player has won the game by getting three in a row.
     * @param playerState       State of the player you wish to check has won.
     * @return                  Returns true if there is a win.
     */
    public boolean hasWon(String playerState) {
        String threeInARow = playerState + playerState + playerState;
        String charsInARow;

        // Check rows if there are three in a row
        for (int row = 0; row < ROWS; row++) {
            charsInARow = board[row][0].getState() + board[row][1].getState() + board[row][2].getState();
            if (threeInARow.equals(charsInARow)) {
                return true;
            }
        }

        // Check columns if there are three in a row
        for (int col = 0; col < COLS; col++) {
            charsInARow = board[0][col].getState() + board[1][col].getState() + board[2][col].getState();
            if (threeInARow.equals(charsInARow)) {
                return true;
            }
        }

        // Check main diagonal
        charsInARow = board[0][0].getState() + board[1][1].getState() + board[2][2].getState();
        if(threeInARow.equals(charsInARow)) {
            return true;
        }

        // Check alternate diagonal
        charsInARow = board[0][2].getState() + board[1][1].getState() + board[2][0].getState();
        if(threeInARow.equals(charsInARow)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if there is a draw in the game.
     * @return                  True if there is a draw.
     */
    public boolean isADraw() {
        return (moves == MAX_MOVES && !(hasWon("X") || hasWon("O")));
    }

    /**
     * Checks if the game is over by using hasWon and isADraw methods.
     * @return                  True if game is over.
     */
    public boolean isGameOver() {
        return (hasWon("X") || hasWon("O") || isADraw());
    }

    /**
     * Check if a given cell is empty in the board.
     * @param row               Row of cell in board.
     * @param col               Column of cell in board.
     * @return                  True if the cell contains the string " ".
     */
    public boolean isCellEmpty(int row, int col) {
        return (board[row][col].getState().equals(" "));
    }

    /**
     * Gives a list of possible moves that can be made.
     * @return                  Returns a list of integer arrays of possible moves in format {row, column}.
     */
    public List<int[]> possibleMoves() {
        List<int[]> availableMoves = new ArrayList<int[]>();

        // If there is a winner, there can be no more moves
        if (hasWon("X") || hasWon("O"))
            return availableMoves;

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if(isCellEmpty(row, col)) {
                    availableMoves.add(new int[] {row, col});
                }
            }
        }
        return availableMoves;
    }

    /**
     * Chosen heuristic evaluation of the board.
     * @param playerState       Maximizing player.
     * @param opponentState     Minimizing player.
     * @param depth             Number of moves until a win is found.
     * @return                  Returns an integer that stands for the board's evaluation score.
     */
    public int evaluateBoard(String playerState, String opponentState, int depth) {
        // Check if either player wins
        if(hasWon(playerState))
            return 100 - depth;
        else if(hasWon(opponentState))
            return -100 + depth;
        return 0;
    }

    /**
     * Sets the cell's state back to " ".
     * @param row               Row of cell in board.
     * @param col               Column of cell in board.
     */
    public void emptyCell(int row, int col) {
        if (!isCellEmpty(row, col)) {
            board[row][col].setState(" ");
        }
    }

    /**
     * Allows the player to make a valid move on the game board.
     * @param row               Row of cell on board.
     * @param col               Column of cell on board.
     * @param playerState       AI.Player that wishes to make a move.
     */
    public void playerMove(int row, int col, String playerState) {
        if (isCellEmpty(row, col)) {
            board[row][col].setState(playerState);
        }
    }

    /**
     * Prints the current game board.
     */
    public void printGameBoard() {
        /** Prints out the GameBoard.GameBoard as such:
           |   |
         ----------
           |   |
         ----------
           |   |
         */

        System.out.println(board[0][0].getState() + " | " + board[0][1].getState() + " | " + board[0][2].getState()) ;
        System.out.println("----------");
        System.out.println(board[1][0].getState() + " | " + board[1][1].getState() + " | " + board[1][2].getState()) ;
        System.out.println("----------");
        System.out.println(board[2][0].getState() + " | " + board[2][1].getState() + " | " + board[2][2].getState()) ;
        System.out.println("");
    }

    /**
     * Resets the current game board.
     */
    public void resetGameBoard() {
        moves = 0;
        for(int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col].setState(" ");
            }
        }
    }
}
