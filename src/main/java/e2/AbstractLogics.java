package e2;

import java.util.Optional;
import java.util.Set;

public class AbstractLogics implements Logics {

    private Grid grid;
    private Set<Pair<Integer, Integer>> mines;
    public AbstractLogics(final Grid grid, final MineGenerator mineGenerator) {
        this.grid = grid;
        this.mines = mineGenerator.generateMines();
    }
    @Override
    public Optional<Integer> cell(Pair<Integer, Integer> pos) {
        return Optional.empty();
    }

    @Override
    public boolean hasWon() {
        return false;
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> pos) {
        return false;
    }

    @Override
    public boolean isFlag(Pair<Integer, Integer> pos) {
        return false;
    }

    @Override
    public void toggleFlag(Pair<Integer, Integer> pos) {

    }

}
