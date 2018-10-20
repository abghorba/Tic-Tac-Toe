import java.util.ArrayList;
import java.util.List;

public class GameBoard
{
    private final static int ROWS = 3;
    private final static int COLS = 3;
    private final static int MAX_MOVES = 9;

    private Cell[][] board;

    public int moves;

    public GameBoard() {
        board = new Cell[ROWS][COLS];

        for(int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                board[row][col] = new Cell();
            }
        }

        moves = 0;
    }

    public boolean hasWon(String playerState) {
        String threeInARow = playerState + playerState + playerState;
        String charsInARow = "";

        // Check rows if there are three in a row
        for (int row = 0; row < ROWS; row++)
        {
            charsInARow = board[row][0].getState() + board[row][1].getState() + board[row][2].getState();
            if (threeInARow.equals(charsInARow))
            {
                return true;
            }
        }

        // Check columns if there are three in a row
        for (int col = 0; col < COLS; col++)
        {
            charsInARow = board[0][col].getState() + board[1][col].getState() + board[2][col].getState();
            if (threeInARow.equals(charsInARow))
            {
                return true;
            }
        }

        // Check main diagonal
        charsInARow = board[0][0].getState() + board[1][1].getState() + board[2][2].getState();
        if(threeInARow.equals(charsInARow))
        {
            return true;
        }

        // Check alternate diagonal
        charsInARow = board[0][2].getState() + board[1][1].getState() + board[2][0].getState();
        if(threeInARow.equals(charsInARow))
        {
            return true;
        }
        return false;
    }

    public boolean isADraw() {
        if (moves == MAX_MOVES && !(hasWon("X") || hasWon("O")))
        {
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        if (hasWon("X") || hasWon("O") || isADraw())
        {
            return true;
        }
        return false;
    }

    public boolean isCellEmpty(int row, int col) {
        if (board[row][col].getState().equals(" "))
        {
            return true;
        }
        return false;
    }

    public List<int[]> possibleMoves() {
        List<int[]> availableMoves = new ArrayList<int[]>();

        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                if(isCellEmpty(row, col))
                {
                    availableMoves.add(new int[] {row, col});
                }
            }
        }

        return availableMoves;
    }

    public int evaluateBoard(String playerState, String opponentState) {
        // Check if either player wins
        if(hasWon(playerState))
            return 100;
        else if(hasWon(opponentState))
            return -100;
        else
            return 0;
    }

    public void emptyCell(int row, int col) {
        if (!isCellEmpty(row, col))
        {
            board[row][col].setState(" ");
        }
    }

    public void playerMove(int row, int col, String playerState) {
        if (isCellEmpty(row, col))
        {
            board[row][col].setState(playerState);
        }

    }

    public void printGameBoard() {
        /** Prints out the GameBoard as such:
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

    public void resetGameBoard() {
        moves = 0;
        for(int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                board[row][col].setState(" ");
            }
        }
    }
}
