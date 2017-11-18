package model.damage.impl;

import lombok.Data;
import model.damage.Damage;

import javax.annotation.Nonnull;

@Data
public final class DamageImpl implements Damage<Integer> {
    private final int count;
    private final DamageType type;

    @Override
    public void visitBy(@Nonnull final Visitor<Integer> visitor) {
        type.visitBy(visitor, count);
    }

    public enum DamageType {
        HP {
            @Override
            void visitBy(@Nonnull final Visitor<Integer> visitor, Integer damage) {
                visitor.onHPDamage(damage);
            }
        },

        PWR {
            @Override
            void visitBy(@Nonnull final Visitor<Integer> visitor, Integer damage) {
                visitor.onPWRDamage(damage);
            }
        },

        PURE_HP {
            @Override
            void visitBy(@Nonnull final Visitor<Integer> visitor, Integer damage) {
                visitor.onPureHPDamage(damage);
            }
        };

        abstract void visitBy(@Nonnull final Visitor<Integer> visitor, Integer damage);
    }
}