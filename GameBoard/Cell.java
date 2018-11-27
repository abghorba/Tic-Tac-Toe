package GameBoard;

class Cell  {
    private String state;

    /**
     * Initializes all cells as empty.
     */
    Cell() {
        state = " ";
    }

    /**
     * Set the state of each cell.
     * @param state         Must take a value of "X", "O", or " "
     */
    void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the state of the cell.
     * @return          Returns the state of the cell.
     */
    String getState() {
        return state;
    }
}
