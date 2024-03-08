package e2;

import java.util.Set;

public class StaticMineGenerator implements MineGenerator {

    private final Grid grid;
    private final Set<Pair<Integer, Integer>> mines;
    public StaticMineGenerator(Grid grid, Set<Pair<Integer, Integer>> mines) {
        if (grid.getWidth() <= 0 || grid.getHeight() <= 0)
            throw new IllegalArgumentException("Cannot create logics with grid size smaller than 1");
        if (mines.size() > grid.getWidth()*grid.getHeight())
            throw new IllegalArgumentException("Cannot create logics with more mines than cells");
        this.grid = grid;
        this.mines = mines;
    }

    @Override
    public Set<Pair<Integer, Integer>> generateMines() {
        return this.mines;
    }

    @Override
    public Grid grid() {
        return this.grid;
    }
}
