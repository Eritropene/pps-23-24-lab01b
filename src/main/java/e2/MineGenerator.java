package e2;

import java.util.Set;

public interface MineGenerator {
    Set<Pair<Integer, Integer>> generateMines();
    Grid grid();
}
