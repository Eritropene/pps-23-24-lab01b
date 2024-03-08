package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomMineGeneratorTest {
    private MineGenerator mineGenerator;
    private final int size = 5;
    private final int mines = 8;

    @BeforeEach
    void init() {
        this.mineGenerator = new RandomMineGenerator(new SquareGrid(size), mines);
    }
    @Test
    void cannotCreateGeneratorWithNegativeSize() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new RandomMineGenerator(new SquareGrid(-2), mines)
        );
    }
    @Test
    void cannotCreateGeneratorWithNegativeMines() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new RandomMineGenerator(new SquareGrid(size), -4)
        );
    }
    @Test
    void cannotCreateGeneratorWithMoreMinesThanCells() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new RandomMineGenerator(new SquareGrid(2), mines)
        );
    }
    @Test
    void generateCorrectNumberOfMines() {
        assertEquals(mines, mineGenerator.generateMines().size());
    }
    @Test
    void generateMinesInsideGrid() {
        for (var mine : mineGenerator.generateMines()) {
            try {
                mineGenerator.grid().getCell(mine);
            } catch (IllegalArgumentException e) {
                fail();
            }
        }
    }
}