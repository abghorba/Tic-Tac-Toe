public class Player
{
    private GameBoard board;
    private States playerState;

    public Player(GameBoard board, String state)
    {
        this.board = board;
        if (state == "X")
        {
            playerState = States.CROSS;
        }
        else if (state == "O")
        {
            playerState = States.NOUGHT;
        }
    }

    public boolean isValidMove(int row, int col)
    {
        if (row < 0 || row >= 3 || col < 0 || col >= 3)
        {
            return false;
        }
        else if(board.isCellEmpty(row,col))
        {
            return true;
        }
        return false;
    }

    public void makeMove(int row, int col)
    {
        board.playerMove(row, col, playerState);
    }

}
