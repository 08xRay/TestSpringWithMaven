package model.stats;

import javax.annotation.Nonnull;

/**
 * @author Stanislav Raytsin
 * @since 15.11.2017.
 */
public interface Vitality<T> {
    @Nonnull T getHP();
    void setHP(@Nonnull T hp);
    boolean isAlive();
}
