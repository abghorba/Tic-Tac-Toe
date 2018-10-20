enum States { EMPTY, CROSS, NOUGHT }

public class Cell
{
    private States state;

    public Cell()
    {
        state = States.EMPTY;
    }

    public void setState(States state) {
        this.state = state;
    }

    public String getState()
    {
        if (state == States.CROSS)
        {
            return "X";
        }
        else if (state == States.NOUGHT)
        {
            return "O";
        }
        return " ";

    }
}
