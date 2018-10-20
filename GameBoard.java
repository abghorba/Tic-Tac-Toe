public class GameBoard
{
    private final static int ROWS = 3;
    private final static int COLS = 3;
    private final static int MAX_MOVES = 9;

    private Cell[][] board;

    public int moves;

    public GameBoard()
    {
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

    public boolean threeInARow(String s1, String s2, String s3)
    {
        String s = s1 + s2 + s3;
        if (s.equals("XXX") || s.equals("OOO"))
        {
            return true;
        }
        return false;
    }

    public boolean isAWin()
    {
        // Check rows if there are three in a row
        for (int row = 0; row < ROWS; row++)
        {
            if (threeInARow(board[row][0].getState(), board[row][1].getState(), board[row][2].getState()))
            {
                return true;
            }
        }

        // Check columns if there are three in a row
        for (int col = 0; col < COLS; col++)
        {
            if (threeInARow(board[0][col].getState(), board[1][col].getState(), board[2][col].getState()))
            {
                return true;
            }
        }

        // Check diagonals if there are three in a row
        if(threeInARow(board[0][0].getState(), board[1][1].getState(), board[2][2].getState()))
        {
            return true;
        }
        else if(threeInARow(board[0][2].getState(), board[1][1].getState(), board[2][0].getState()))
        {
            return true;
        }
        return false;
    }

    public boolean isADraw()
    {
        if (moves == MAX_MOVES && !isAWin())
        {
            return true;
        }
        return false;
    }

    public boolean isGameOver()
    {
        if (isAWin() || isADraw())
        {
            return true;
        }
        return false;
    }

    public boolean isCellEmpty(int row, int col)
    {
        if (board[row][col].getState() == " ")
        {
            return true;
        }
        return false;
    }

    public void playerMove(int row, int col, States playerState)
    {
        if (isCellEmpty(row, col))
        {
            board[row][col].setState(playerState);
        }

    }

    public void printGameBoard()
    {
        System.out.println(board[0][0].getState() + " | " + board[0][1].getState() + " | " + board[0][2].getState()) ;
        System.out.println("----------");
        System.out.println(board[1][0].getState() + " | " + board[1][1].getState() + " | " + board[1][2].getState()) ;
        System.out.println("----------");
        System.out.println(board[2][0].getState() + " | " + board[2][1].getState() + " | " + board[2][2].getState()) ;
    }

    public void resetGameBoard()
    {
        moves = 0;
        for(int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                board[row][col].setState(States.EMPTY);
            }
        }
    }
}
