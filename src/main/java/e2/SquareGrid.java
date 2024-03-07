package e2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SquareGrid implements Grid {

    private int size;
    private Map<Pair<Integer, Integer>, Integer> cells = new HashMap<>();
    public SquareGrid(final int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Cannot create grid with size smaller than 1");
        this.size = size;
    }
    @Override
    public Integer getWidth() {
        return this.size;
    }

    @Override
    public Integer getHeight() {
        return this.size;
    }

    @Override
    public Optional<Integer> getCell(Pair<Integer, Integer> position) {
        checkPosition(position);
        return Optional.ofNullable(this.cells.get(position));
    }

    @Override
    public Map<Pair<Integer, Integer>, Integer> neighbors(Pair<Integer, Integer> cell) {
        Map<Pair<Integer, Integer>, Integer> neighbors = new HashMap<>();
        for (int dx=-1; dx<=1; dx++)
            for (int dy=-1; dy<=1; dy++)
                if (dx !=)
        return null;
    }

    @Override
    public void setCell(Pair<Integer, Integer> position, Integer value) {
        checkPosition(position);
        this.cells.put(position, value);
    }

    private void checkPosition(Pair<Integer, Integer> position) {
        if (position.getX() < 0 || position.getX() >= this.size ||
            position.getY() < 0 || position.getY() >= this.size)
            throw new ArrayIndexOutOfBoundsException("Position out of grid");
    }
    private Pair<Integer, Integer> clampPosition(Pair<Integer, Integer> position) {
        Integer x = position.getX();
        Integer y = position.getY();
        if (x < 0)
            x = 0;
        if (x >= this.size)
            x = this.size - 1;
        if (y < 0)
            y = 0;
        if (y >= this.size)
            y = this.size - 1;
        return new Pair<>(x, y);
    }

}
