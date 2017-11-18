package strategy.impl;

import model.character.AbstractCharacter;
import strategy.Strategy;

import javax.annotation.Nonnull;

/**
 * @author Stanislav Raytsin
 * @since 18.11.2017.
 */

public class SimpleFightStrategy implements Strategy<AbstractCharacter> {
    @Override
    public void execute(@Nonnull AbstractCharacter v1, @Nonnull AbstractCharacter v2) {
        System.out.println("fight strategy with:\n v1 = " + v1 + "\n"
                + " v2 = " + v2);
    }
}
