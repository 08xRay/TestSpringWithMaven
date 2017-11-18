package manager;

import context.Context;

import javax.annotation.Nonnull;

/**
 * @author Stanislav Raytsin
 * @since 18.11.2017.
 */
public interface FightManager<T> extends Manager<Context<T>> {
    void fight(@Nonnull T v1, @Nonnull T v2);
}
