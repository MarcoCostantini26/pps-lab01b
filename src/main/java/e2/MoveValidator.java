package e2;

public interface MoveValidator {

    /**
     * attempt to move Knight on position row,col, if possible
     *
     * @param row
     * @param col
     * @return true if it's possible false otherwise
     */
    boolean validateKnightMove(int row, int col);

    boolean hasKnight(int row, int col);

    boolean hasPawn(int row, int col);

}
