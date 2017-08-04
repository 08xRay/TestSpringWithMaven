package model.damage;


import javax.annotation.Nonnull;

public final class Damage {
    private final DamageType type;
    private final int count;

    public Damage(int count, @Nonnull DamageType type) {
        this.count = count;
        this.type = type;
    }

    public DamageType getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public interface Visitor {
        void onHPDamage(Damage damage);
        void onPWRDamage(Damage damage);
        void onPureHPDamage(Damage damage);
    }

    public void visitBy(Visitor visitor) {
        this.type.visitBy(visitor, this);
    }

    public enum DamageType {
        HP {
            @Override
            public void visitBy(Visitor visitor, Damage damage) {
                visitor.onHPDamage(damage);
            }
        },

        PWR {
            @Override
            public void visitBy(Visitor visitor, Damage damage) {
                visitor.onPWRDamage(damage);
            }
        },

        PURE_HP {
            @Override
            public void visitBy(Visitor visitor, Damage damage) {
                visitor.onPureHPDamage(damage);
            }
        };

        abstract void visitBy(Visitor visitor, Damage damage);
    }
}