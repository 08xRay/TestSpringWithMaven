package model.stats;

import javax.annotation.Nonnull;

/**
 * @author Stanislav Raytsin
 * @since 15.11.2017.
 */
public interface Power<T> {
    @Nonnull T getPower();
    void setPower(@Nonnull T power);
}