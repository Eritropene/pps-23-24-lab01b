package e2;

import java.util.Optional;

public class LogicsImpl extends AbstractLogics {

    public LogicsImpl(int size, int mines) {
        super(new RandomMineGenerator(new SquareGrid(size), mines));
    }

}
