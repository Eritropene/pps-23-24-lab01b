package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;
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
    void isInside() {
        assertAll(
                () -> assertTrue(grid.isInside(new Pair<>(0, 0))),
                () -> assertFalse(grid.isInside(new Pair<>(-1, -1)))
        );
    }
    @Test
    void getNeighbors() {
        Pair<Integer, Integer> target = new Pair<>(1,1);
        Map<Pair<Integer, Integer>, Optional<Integer>> neighbors = Map.ofEntries(
                Map.entry(new Pair<>(0,0), Optional.empty()),
                Map.entry(new Pair<>(0,1), Optional.empty()),
                Map.entry(new Pair<>(0,2), Optional.empty()),

                Map.entry(new Pair<>(1,0), Optional.empty()),
                Map.entry(new Pair<>(1,2), Optional.empty()),

                Map.entry(new Pair<>(2,0), Optional.empty()),
                Map.entry(new Pair<>(2,1), Optional.empty()),
                Map.entry(new Pair<>(2,2), Optional.empty())
        );
        assertEquals(neighbors, grid.neighbors(target));
    }
    @Test
    void getNeighborsOfTopLeftCorner() {
        Pair<Integer, Integer> target = new Pair<>(0,0);
        Map<Pair<Integer, Integer>, Optional<Integer>> neighbors = Map.ofEntries(
                Map.entry(new Pair<>(0,1), Optional.empty()),
                Map.entry(new Pair<>(1,1), Optional.empty()),
                Map.entry(new Pair<>(1,0), Optional.empty())
        );
        assertEquals(neighbors, grid.neighbors(target));
    }
    @Test
    void getNeighborsOfBottomRightCorner() {
        Pair<Integer, Integer> target = new Pair<>(size-1,size-1);
        Map<Pair<Integer, Integer>, Optional<Integer>> neighbors = Map.ofEntries(
                Map.entry(new Pair<>(size-2,size-1), Optional.empty()),
                Map.entry(new Pair<>(size-2,size-2), Optional.empty()),
                Map.entry(new Pair<>(size-1,size-2), Optional.empty())
        );
        assertEquals(neighbors, grid.neighbors(target));
    }
    @Test
    void cannotGetNeighborsOfCellOutsideGrid() {
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> grid.neighbors(new Pair<>(-1, -1))
        );
    }
    @Test
    void getAllCellsInitiallyEmpty() {
        for (var cell : grid.allCells().entrySet())
            if (cell.getValue().isPresent())
                fail();
    }
    @Test
    void allCellsOfCorrectSize() {
        assertEquals(size*size, grid.allCells().size());
    }
}