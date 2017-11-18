package strategy;

import javax.annotation.Nonnull;

/**
 * @author Stanislav Raytsin
 * @since 18.11.2017.
 */
public interface Strategy<T> {
    void execute(@Nonnull T v1, @Nonnull T v2);
}
