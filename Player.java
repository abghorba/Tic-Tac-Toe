public class Player
{
    protected GameBoard board;
    protected String playerState;
    protected String opponentState;

    public Player(GameBoard board, String playerState) {
        this.board = board;
        this.playerState = playerState;

        if (playerState.equals("X"))
            opponentState = "O";
        else if (playerState.equals("O"))
            opponentState = "X";
    }

    public boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3)
        {
            return false;
        }
        else if(board.isCellEmpty(row, col))
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
