package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LogicsImplTest {

    private Logics logics;
    private final int size = 5;
    private int mines;
    private final Set<Pair<Integer, Integer>> minesSet = Set.of(
            new Pair<>(0,0),
            new Pair<>(0,1),
            new Pair<>(3,2),
            new Pair<>(4,2)
    );

    @BeforeEach
    void init() {
        this.mines = minesSet.size();
        this.logics = new TestLogicsImpl(size, minesSet);
    }
    @Test
    void cannotCreateLogicsWithNegativeSize() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new LogicsImpl(-5, 4)
        );
    }
    @Test
    void cannotCreateLogicsWithNegativeMines() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new LogicsImpl(5, -4)
        );
    }
    @Test
    void cannotCreateLogicsWithMoreMinesThanCells() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new LogicsImpl(2, 5)
        );
    }
    @Test
    void cannotAccessOutsideCell() {
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> logics.cell(new Pair<>(size, size))
        );
    }
    @Test
    void initiallyCellsHaveNoValue() {
        for (int x=0; x<size; x++) {
            for (int y=0; y<size; y++) {
                if (logics.cell(new Pair<>(x,y)).isPresent())
                    fail();
            }
        }
    }
    @Test
    void minesAreActuallyMines() {
        for (var mine : minesSet) {
            if (!logics.isMine(mine))
                fail();
        }
    }
    @Test
    void initiallyNoFlags() {
        for (int x=0; x<size; x++) {
            for (int y=0; y<size; y++) {
                if (logics.isFlag(new Pair<>(x,y)))
                    fail();
            }
        }
    }
    @Test
    void canPlaceFlag() {
        final Pair<Integer, Integer> flag = new Pair<>(0, 0);
        logics.toggleFlag(flag);
        assertTrue(logics.isFlag(flag));
    }
    @Test
    void canRemoveFlag() {
        final Pair<Integer, Integer> flag = new Pair<>(0, 0);
        logics.toggleFlag(flag);
        logics.toggleFlag(flag);
        assertFalse(logics.isFlag(flag));
    }
    @Test
    void cannotPlaceFlagOutsideGrid() {
        final Pair<Integer, Integer> flag = new Pair<>(-1, -1);
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> logics.toggleFlag(flag)
        );
    }
    @Test
    void hitMine() {
        final Pair<Integer, Integer> minePosition = new Pair<>(0, 0);
        assertTrue(logics.hit(minePosition));
    }
    @Test
    void missMine() {
        final Pair<Integer, Integer> notMinePosition = new Pair<>(2, 2);
        assertFalse(logics.hit(notMinePosition));
    }
    @Test
    void cannotHitCellOutsideGrid() {
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> logics.hit(new Pair<>(-1, -1))
        );
    }
    @Test
    void calculateCorrectDistancesFromMines() {
        logics.hit(new Pair<>(0, 4));
        assertAll(
                () -> assertEquals(0, logics.cell(new Pair<>(0, 4)).get()),
                () -> assertEquals(1, logics.cell(new Pair<>(2, 3)).get()),
                () -> assertEquals(2, logics.cell(new Pair<>(3, 3)).get())
        );
    }
    @Test
    void initiallyHasNotWon() {
        assertFalse(logics.victory());
    }
    @Test
    void hasNotWon() {
        logics.hit(new Pair<>(0, 1));
        assertFalse(logics.victory());
    }
    @Test
    void hasWon() {
        logics.hit(new Pair<>(0, 4));
        logics.hit(new Pair<>(3, 0));
        assertTrue(logics.victory());
    }
}