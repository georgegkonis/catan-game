package gr.upatras.ceid.backend.utility;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.IntStream;

import static gr.upatras.ceid.backend.constants.GameConstants.NUMBER_OF_DICE;
import static gr.upatras.ceid.backend.constants.GameConstants.MIN_DIE_VALUE;
import static gr.upatras.ceid.backend.constants.GameConstants.MAX_DIE_VALUE;

@Component
public class DiceSimulator {

    public int simulateDiceRoll() {
        return IntStream.range(0, NUMBER_OF_DICE)
                .map(i -> rollDie())
                .sum();
    }

    private static int rollDie() {
        Random random = new Random();
        return random.nextInt(MAX_DIE_VALUE) + MIN_DIE_VALUE;
    }
}
