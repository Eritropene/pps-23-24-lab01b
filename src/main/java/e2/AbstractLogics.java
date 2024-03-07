package e2;

import java.util.Optional;

public class AbstractLogics implements Logics {

    private int size;
    private int mines;

    public AbstractLogics() {

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

    protected int getSize() {
        return size;
    }

    protected int getMines() {
        return mines;
    }
}
