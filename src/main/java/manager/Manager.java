package manager;

import context.Context;

import javax.annotation.Nonnull;

/**
 * @author Stanislav Raytsin
 * @since 16.11.2017.
 */
public interface Manager <C extends Context<?>> {
    void init(@Nonnull C context);
    @Nonnull C getContext();
}
