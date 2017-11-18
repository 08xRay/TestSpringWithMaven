package context.impl;

import context.Context;
import model.character.AbstractCharacter;
import strategy.Strategy;

import javax.annotation.Nonnull;

/**
 * @author Stanislav Raytsin
 * @since 17.11.2017.
 */
public final class GameContext implements Context<AbstractCharacter> {
    private final Strategy<AbstractCharacter> strategy;

    public GameContext(@Nonnull Strategy<AbstractCharacter> strategy) {
        this.strategy = strategy;
    }

    @Nonnull
    @Override
    public Strategy<AbstractCharacter> getStrategy() {
        return strategy;
    }
}
