package e2;

import java.util.Set;

public class TestLogicsImpl extends AbstractLogics {
    public TestLogicsImpl(int size, Set<Pair<Integer, Integer>> mines) {
        super(new StaticMineGenerator(new SquareGrid(size), mines));
    }
}
