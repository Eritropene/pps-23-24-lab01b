package e2;

import java.util.Optional;
import java.util.Set;

public class AbstractLogics implements Logics {

    private Grid grid;
    private Set<Pair<Integer, Integer>> mines;
    public AbstractLogics(final MineGenerator mineGenerator) {
        this.grid = mineGenerator.grid();
        this.mines = mineGenerator.generateMines();
        calculateDistances();
    }
    @Override
    public Optional<Integer> cell(Pair<Integer, Integer> pos) {
        return this.grid.getCell(pos);
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
    @Override
    public boolean hit(Pair<Integer, Integer> pos) {
        return false;
    }
    private void calculateDistances() {
        for (var cell : this.grid.allCells().entrySet()) {
            var position = cell.getKey();
            int counter = 0;
            for (var neighbor : this.grid.neighbors(position).entrySet())
                if (isMine(neighbor.getKey())) counter += 1;

            this.grid.setCell(position, counter);
        }
    }

}
