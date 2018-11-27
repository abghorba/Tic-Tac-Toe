package AI;

import GameBoard.GameBoard;
import java.util.List;

public class MiniMaxComputer extends Player {

    public MiniMaxComputer(GameBoard board, String state) {
        super(board, state);
    }

    @Override
    /**
     * Overrides the makeMove method in the Player class.
     * Allows the computer to use the minimax algorithm to determine best move.
     */
    public void makeMove() {
        System.out.println("Computer's turn.");
        System.out.println();
        int[] bestMove = minimax(board.moves, true);
        board.playerMove(bestMove[1], bestMove[2], playerState);
        board.moves++;
        board.printGameBoard();
    }

    /**
     * Uses the minimax algorithm to determine next move.
     * @param depth             How many moves have taken place so far.
     * @param isComputer        Allows for the switching of turns. Begin with true.
     * @return                  Returns an integer array of bestScore, bestRow, and bestCol.
     */
    private int[] minimax(int depth, boolean isComputer) {
         int bestScore = (isComputer) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
         int score;
         int bestRow = -1;
         int bestCol = -1;

         List<int[]> availableMoves = board.possibleMoves();

         if (availableMoves.isEmpty()) {
             bestScore = board.evaluateBoard(playerState, opponentState, depth);
         }
         else {
             for (int[] move : availableMoves) {
                 if(isComputer) {
                     board.playerMove(move[0],move[1], playerState);
                     score = minimax(depth + 1, false)[0];
                     if (score > bestScore) {
                         bestScore = score;
                         bestRow = move[0];
                         bestCol = move[1];
                     }
                 }
                 else {
                     board.playerMove(move[0],move[1], opponentState);
                     score = minimax(depth + 1, true)[0];
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

    @Override
    /**
     * Overrides the getName method in the Player class.
     * @return      returns "MiniMaxComputer"
     */
    public String getName() {
        return "MiniMaxComputer";
    }
}