package e1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class LogicsTest {

  private Logics logic;
  private final int gridSize = 5;
  private Pair<Integer, Integer> initKnightPosition = new Pair<>(0, 0);
  private Pair<Integer, Integer> initPawnPosition = new Pair<>(gridSize-1, gridSize-1);
  @BeforeEach
  void init() {
    this.logic = new LogicsFactoryImpl(gridSize).createStaticLogics(initKnightPosition, initPawnPosition);
  }

  @Test
  void initKnightAndPawnInsideGrid() {
    boolean knightIsInside = false;
    boolean pawnIsInside = false;
    for (int x=0; x<gridSize; x++) {
      for (int y=0; y<gridSize; y++) {
        knightIsInside |= this.logic.hasKnight(x, y);
        pawnIsInside |= this.logic.hasPawn(x, y);
      }
    }
    assertTrue(knightIsInside && pawnIsInside);
  }
  @Test
  void initKnightNotInPawnPosition() {
    boolean inSamePosition = false;
    for (int x=0; x<gridSize; x++) {
      for (int y=0; y<gridSize; y++) {
        inSamePosition |= this.logic.hasKnight(x, y) && this.logic.hasPawn(x, y);
      }
    }
    assertFalse(inSamePosition);
  }
  @Test
  void moveKnightOutsideGrid() {
    assertThrows(
            IndexOutOfBoundsException.class,
            () -> this.logic.hit(gridSize, gridSize)
    );
  }
}
