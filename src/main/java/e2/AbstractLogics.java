package e2;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class AbstractLogics implements Logics {

    private final Grid grid;
    private final Set<Pair<Integer, Integer>> mines;
    private final Set<Pair<Integer, Integer>> flags = new HashSet<>();
    public AbstractLogics(final MineGenerator mineGenerator) {
        this.grid = mineGenerator.grid();
        this.mines = mineGenerator.generateMines();
    }
    @Override
    public Optional<Integer> cell(Pair<Integer, Integer> pos) {
        return this.grid.getCell(pos);
    }

    @Override
    public boolean victory() {
        var remainingCells = this.grid.allCells().entrySet().stream()
                .filter(c -> c.getValue().isEmpty())
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        return remainingCells.equals(this.mines);
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> pos) {
        return this.mines.contains(pos);
    }

    @Override
    public boolean isFlag(Pair<Integer, Integer> pos) {
        return this.flags.contains(pos);
    }

    @Override
    public void toggleFlag(Pair<Integer, Integer> pos) {
        if (!this.grid.isInside(pos))
            throw new ArrayIndexOutOfBoundsException("Cannot place flag outside the grid");
        if (isFlag(pos))
            this.flags.remove(pos);
        else
            this.flags.add(pos);
    }
    @Override
    public boolean hit(Pair<Integer, Integer> pos) {
        if (cell(pos).isEmpty()) {
            this.grid.setCell(pos, calculateDistance(pos));

            if (cell(pos).get() == 0)
                for (var neighbor : this.grid.neighbors(pos).entrySet()) {
                    var neighborPosition = neighbor.getKey();
                    hit(neighborPosition);
                }
        }
        return isMine(pos);
    }
    private Integer calculateDistance(Pair<Integer, Integer> pos) {
        int counter = 0;
        for (var neighbor : this.grid.neighbors(pos).entrySet())
            if (isMine(neighbor.getKey())) counter += 1;
        return counter;
    }

}
