package e1;

public class StaticPositionInitializer implements PositionInitializer {

    private Pair<Integer,Integer> knightPosition;
    private Pair<Integer,Integer> pawnPosition;
    public StaticPositionInitializer(Pair<Integer, Integer> knightPosition, Pair<Integer, Integer> pawnPosition) {
        this.knightPosition = knightPosition;
        this.pawnPosition = pawnPosition;
    }

    @Override
    public Pair<Integer, Integer> initKnightPosition() {
        return this.knightPosition;
    }

    @Override
    public Pair<Integer, Integer> initPawnPosition() {
        return this.pawnPosition;
    }
}
