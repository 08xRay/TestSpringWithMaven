package model.damage;

import lombok.Data;

import javax.annotation.Nonnull;

@Data
public final class Damage {
    private final int count;
    private final DamageType type;

    public interface Visitor {
        void onHPDamage(int damage);
        void onPWRDamage(int damage);
        void onPureHPDamage(int damage);
    }

    public void visitBy(@Nonnull Visitor visitor) {
        type.visitBy(visitor, count);
    }

    public enum DamageType {
        HP {
            @Override
            void visitBy(@Nonnull Visitor visitor, int damage) {
                visitor.onHPDamage(damage);
            }
        },

        PWR {
            @Override
            void visitBy(@Nonnull Visitor visitor, int damage) {
                visitor.onPWRDamage(damage);
            }
        },

        PURE_HP {
            @Override
            void visitBy(@Nonnull Visitor visitor, int damage) {
                visitor.onPureHPDamage(damage);
            }
        };

        abstract void visitBy(@Nonnull Visitor visitor, int damage);
    }
}