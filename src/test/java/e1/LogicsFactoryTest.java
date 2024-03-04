package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogicsFactoryTest {

    private final int gridSize = 5;
    private LogicsFactory logicsFactory = new LogicsFactoryImpl(gridSize);
    @Test
    void getRandomLogics() {
        Logics logics = logicsFactory.createRandomLogics();
        assertNotEquals(logics, null);
    }
    @Test
    void getStaticLogics() {
        final Pair<Integer, Integer> knightPos = new Pair<>(2, 3);
        final Pair<Integer, Integer> pawnPos = new Pair<>(0, 0);
        final Logics logics = logicsFactory.createStaticLogics(knightPos, pawnPos);
        assertAll(
                () -> assertTrue(logics.hasKnight(2,3)),
                () -> assertTrue(logics.hasPawn(0,0))
        );
    }
    @Test
    void getStaticLogicsWithSamePositions() {
        final Pair<Integer, Integer> samePos = new Pair<>(2, 3);
        assertThrows(
                IllegalArgumentException.class,
                () -> logicsFactory.createStaticLogics(samePos, samePos)
        );
    }
    @Test
    void getStaticLogicsWithOutsidePositions() {
        final Pair<Integer, Integer> outsideKnightPos = new Pair<>(0, gridSize);
        final Pair<Integer, Integer> outsidePawnPos = new Pair<>(gridSize, 0);
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> logicsFactory.createStaticLogics(outsideKnightPos, outsidePawnPos)
        );
    }
}
