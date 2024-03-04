package e1;

public interface LogicsFactory {


    /**
     * Create a Logics implementation with random position initialization
     * @return the Logics implementation
     */
    Logics createRandomLogics();

    /**
     * Create a Logics implementation with defined initial position
     * @return the Logics implementation
     */
    Logics createStaticLogics(Pair<Integer, Integer> knightPos, Pair<Integer, Integer> pawnPos);
}
