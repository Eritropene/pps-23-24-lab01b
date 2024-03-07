package e2;

import java.util.Map;
import java.util.Optional;

public interface Grid {
    Integer getWidth();
    Integer getHeight();
    Optional<Integer> getCell(Pair<Integer, Integer> position);
    void setCell(Pair<Integer, Integer> position, Integer value);
    Map<Pair<Integer, Integer>,Integer> neighbors(Pair<Integer, Integer> cell);
}
