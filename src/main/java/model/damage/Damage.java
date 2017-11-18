package model.damage;

import javax.annotation.Nonnull;

/**
 * @author Stanislav Raytsin
 * @since 15.11.2017.
 */
public interface Damage <T> {
    void visitBy(@Nonnull final Visitor<T> visitor);

    interface Visitor<T> {
        void onHPDamage(T damage);
        void onPWRDamage(T damage);
        void onPureHPDamage(T damage);
    }
}
