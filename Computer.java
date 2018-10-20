import java.util.List;

public class Computer extends Player {

    public Computer(GameBoard board, String state) {
        super(board, state);
    }

    public void makeMove() {
        int[] bestMove = minimax(4, true);
        board.playerMove(bestMove[1], bestMove[2], playerState);
    }

    public int[] minimax(int depth, boolean isMaximizingPlayer) {
         int bestScore = (isMaximizingPlayer) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
         int score;
         int bestRow = -1;
         int bestCol = -1;

         List<int[]> availableMoves = board.possibleMoves();

         if (availableMoves.isEmpty() || depth == 0) {
             bestScore = board.evaluateBoard(playerState, opponentState);
         }
         else {
             for (int[] move : availableMoves) {
                 if(isMaximizingPlayer) {
                     board.playerMove(move[0],move[1], playerState);
                     score = minimax(depth - 1, !isMaximizingPlayer)[0];
                     if (score > bestScore) {
                         bestScore = score;
                         bestRow = move[0];
                         bestCol = move[1];
                     }
                 }
                 else {
                     board.playerMove(move[0],move[1], opponentState);
                     score = minimax(depth-1, isMaximizingPlayer)[0];
                     if (score < bestScore) {
                         bestScore = score;
                         bestRow = move[0];
                         bestCol = move[1];
                     }
                 }
                 board.emptyCell(move[0], move[1]);
             }
         }
        return new int[] {bestScore, bestRow, bestCol};
    }
}