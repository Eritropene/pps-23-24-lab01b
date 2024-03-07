package e2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicsImplTest {

    private Logics logics;
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
        final int size = 5;
        Logics logics = new LogicsImpl(size, 4);
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> logics.cell(new Pair<>(size, size))
        );
    }
    @Test
    void allCellsInitiallyEmpty() {
        final int size = 5;
        Logics logics = new LogicsImpl(size, 4);
        for (int x=0; x<size; x++) {
            for (int y=0; y<size; y++) {
                if (logics.cell(new Pair<>(x,y)).isPresent())
                    fail();
            }
        }
    }
}