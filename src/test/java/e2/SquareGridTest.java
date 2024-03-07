package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SquareGridTest {

    private Grid grid;
    private final int size = 5;
    @BeforeEach
    void init() {
        this.grid = new SquareGrid(size);
    }
    @Test
    void cannotCreateGridWithNegativeSize() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SquareGrid(-5)
        );
    }
    @Test
    void shapeIsSquare() {
        assertAll(
                () -> assertEquals(size, grid.getWidth()),
                () -> assertEquals(size, grid.getHeight())
        );
    }
    @Test
    void cannotGetCellOutsideGrid() {
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> grid.getCell(new Pair<>(size, -1))
        );
    }
    @Test
    void getEmptyCell() {
        assertTrue( grid.getCell(new Pair<>(0, 0)).isEmpty() );
    }
    @Test
    void cannotSetCellOutsideGrid() {
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> grid.setCell(new Pair<>(size, -1), 0)
        );
    }
    @Test
    void getCell() {
        Pair<Integer, Integer> pos = new Pair<>(0,0);
        grid.setCell(pos, 3);
        assertEquals(3, grid.getCell(pos).get());
    }
    @Test
    void getNeighbors() {
        Pair<Integer, Integer> target = new Pair<>(1,1);
        Set<Pair<Integer, Integer>> neighbors = Set.of(
                new Pair<>(0,0),
                new Pair<>(0,1),
                new Pair<>(0,2),

                new Pair<>(1,0),
                new Pair<>(1,2),

                new Pair<>(2,0),
                new Pair<>(2,1),
                new Pair<>(2,2)
        );
        assertEquals(neighbors, grid.neighbors(target));
    }
}