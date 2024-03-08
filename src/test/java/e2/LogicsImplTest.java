package e2;

import org.junit.jupiter.api.Assertions;
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
    void allCellsHaveValue() {
        for (int x=0; x<size; x++) {
            for (int y=0; y<size; y++) {
                if (logics.cell(new Pair<>(x,y)).isEmpty())
                    fail();
            }
        }
    }
    @Test
    void getMines() {
        
    }
}