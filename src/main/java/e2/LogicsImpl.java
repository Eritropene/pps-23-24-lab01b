package e2;

import java.util.Optional;

public class LogicsImpl extends AbstractLogics {

    public LogicsImpl(int size, int mines) {
        if (size <= 0)
            throw new IllegalArgumentException("Cannot create logics with grid size smaller than 1");
        if (mines < 0)
            throw new IllegalArgumentException("Cannot create logics with a negative number of mines");
    }

}
