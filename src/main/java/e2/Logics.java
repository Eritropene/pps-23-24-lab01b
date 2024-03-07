package e2;

import java.util.Optional;

public interface Logics {
    Optional<Integer> cell(Pair<Integer, Integer> pos);
    boolean hasWon();
    boolean isMine(Pair<Integer, Integer> pos);
    boolean isFlag(Pair<Integer, Integer> pos);
    void toggleFlag(Pair<Integer, Integer> pos);
}
