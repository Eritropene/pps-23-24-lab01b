package e1;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomPositionInitializer implements PositionInitializer {

    private final Random random;
    private final int gridSize;
    private Pair<Integer, Integer> knightPosition;
    private Pair<Integer, Integer> pawnPosition;
    public RandomPositionInitializer(int size) {
        this.random = new Random();
        this.gridSize = size;
    }
    @Override
    public Pair<Integer, Integer> initKnightPosition() {
        this.knightPosition = randomPositionDifferentFrom(this.pawnPosition);
        return this.knightPosition;
    }
    @Override
    public Pair<Integer, Integer> initPawnPosition() {
        this.pawnPosition = randomPositionDifferentFrom(this.knightPosition);
        return this.pawnPosition;
    }
    private final Pair<Integer,Integer> randomPositionDifferentFrom(final Pair<Integer, Integer> position){
    	Pair<Integer,Integer> newPosition = new Pair<>(this.random.nextInt(gridSize),this.random.nextInt(gridSize));
    	// the recursive call below prevents clash with an existing pawn
    	return position != null && position.equals(newPosition) ? randomPositionDifferentFrom(position) : newPosition;
    }
}
