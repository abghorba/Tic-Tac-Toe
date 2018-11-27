package AI;

import GameBoard.GameBoard;
import java.util.List;

public class AlphaBetaComputer extends Player {

    public AlphaBetaComputer(GameBoard board, String state) {
        super(board, state);
    }

    @Override
    /**
     * Overrides the makeMove method in the Player class.
     * Allows the computer to use the minimax with alpha-beta pruning algorithm to determine best move.
     */
    public void makeMove() {
        System.out.println("Computer's turn.");
        System.out.println();
        int[] bestMove = alphabeta(board.moves, true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        board.playerMove(bestMove[1], bestMove[2], playerState);
        board.moves++;
        board.printGameBoard();
    }

    /**
     * Uses the minimax with alpha-beta pruning algorithm to determine next move.
     * This effectively cuts down the number of game tree nodes to check.
     * @param depth             How many moves have taken place so far.
     * @param isComputer        Allows for the switching of turns. Begin with true.
     * @param alpha             Score we want to maximize.
     * @param beta              Score we want to minimize.
     * @return                  Returns an integer array of score, bestRow, and bestCol.
     */
    private int[] alphabeta(int depth, boolean isComputer, int alpha, int beta) {
        int score;
        int bestRow = -1;
        int bestCol = -1;

        List<int[]> availableMoves = board.possibleMoves();

        if (availableMoves.isEmpty()) {
            score = board.evaluateBoard(playerState, opponentState, depth);
            return new int[] {score, bestRow, bestCol};
        } else {
            for (int[] move : availableMoves) {
                if(isComputer) {
                    board.playerMove(move[0],move[1], playerState);
                    score = alphabeta(depth + 1, false, alpha, beta)[0];
                    if (score > alpha) {
                        alpha = score;
                        bestRow = move[0];
                        bestCol = move[1];
                    }
                } else {
                    board.playerMove(move[0],move[1], opponentState);
                    score = alphabeta(depth + 1, true, alpha, beta)[0];
                    if (score < beta) {
                        beta = score;
                        bestRow = move[0];
                        bestCol = move[1];
                    }
                }
                board.emptyCell(move[0], move[1]);
                if (alpha >= beta) {
                    break;
                }
            }
        }
        score = (isComputer) ? alpha : beta;
        return new int[] {score , bestRow, bestCol};
    }

    @Override
    /**
     * Overrides the getName method in the Player class.
     * @return      returns "AlphaBetaComputer"
     */
    public String getName() {
        return "AlphaBetaComputer";
    }
}
