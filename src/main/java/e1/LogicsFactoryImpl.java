package e1;

public class LogicsFactoryImpl implements LogicsFactory {
    private final int size;

    public LogicsFactoryImpl(int gridSize) {
        this.size = gridSize;
    }
    @Override
    public Logics createRandomLogics() {
        return new LogicsImpl(this.size, new RandomPositionInitializer(this.size));
    }

    @Override
    public Logics createStaticLogics(Pair<Integer, Integer> knightPos, Pair<Integer, Integer> pawnPos) {
        if (knightPos.getX() >= this.size || knightPos.getY() >= this.size ||
                pawnPos.getX() >= this.size || pawnPos.getY() >= this.size)
            throw new IndexOutOfBoundsException("Position cannot be bigger than the grid size");
        return new LogicsImpl(this.size, new StaticPositionInitializer(knightPos, pawnPos));
    }
}
