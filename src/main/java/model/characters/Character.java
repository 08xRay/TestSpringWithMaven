package model.characters;

import model.damage.Damage;
import org.fluttercode.datafactory.impl.DataFactory;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Character {
    private static final DataFactory dataFactory = new DataFactory();
    public final String name;
    private final List<Damage> damageCache;
    private int power;
    private int hp;

    private Character() {
        final int rV = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        for (int i = 0; i < rV; i++) dataFactory.getLastName();
        name = new StringJoiner(" ").add(this.getClass().getSimpleName()).add(dataFactory.getLastName()).toString();
        damageCache = new ArrayList<>();
    }

    protected Character(int power, int hp) {
        this();
        this.power = power;
        this.hp = hp;
    }

    //TODO: this is multiply responsibility, move this method from data class
    public abstract void kick(Character c);

    //TODO: not produce unnecessary getters/setters, keep it clean
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = (power > 0) ? power : 0;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = (hp > 0) ? hp : 0;
    }

    public boolean isAlive() {
        return getHp() > 0;
    }

    //TODO: this functionality is multiply responsibility, move it from data class
    public void takeDamage(Character from, List<Damage> dmg) {
        damageCache.addAll(dmg);
    }

    //TODO: this is multiply responsibility, move this method from data class
    public void applyChanges() {
        if (damageCache.isEmpty())
            return;

        Damage.Visitor visitor = new Damage.Visitor() {
            @Override
            public void onHPDamage(@Nonnull Damage damage) {
                setHp(getHp() - damage.getCount());
            }

            @Override
            public void onPWRDamage(@Nonnull Damage damage) {
                setPower(getPower() - damage.getCount());
            }

            @Override
            public void onPureHPDamage(@Nonnull Damage damage) {
                setHp(getHp() - damage.getCount());
            }
        };

        damageCache.forEach(d -> d.visitBy(visitor));

        damageCache.clear();
    }
}