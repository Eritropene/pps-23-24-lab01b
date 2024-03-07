package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicsImplTest {

    private Logics logics;
    private int size = 5;
    private int mines = 4;
    private void initializeLogics() {
        this.logics = new LogicsImpl(size, mines);
    }
    @Test
    void cannotCreateLogicsWithNegativeSize() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new LogicsImpl(-size, mines)
        );
    }
    @Test
    void cannotCreateLogicsWithNegativeMines() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new LogicsImpl(size, -mines)
        );
    }

    @Test
    void hasWon() {
    }

    @Test
    void isMine() {
    }

    @Test
    void isFlag() {
    }

    @Test
    void toggleFlag() {
    }
}