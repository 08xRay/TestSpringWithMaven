package model.characters;

import lombok.Getter;
import model.damage.Damage;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Character {
    private static final DataFactory dataFactory = new DataFactory();
    public final String name;
    private final List<Damage> damageCache;
    @Getter private int power;
    @Getter private int hp;

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
    public void setPower(int power) {
        this.power = (power > 0) ? power : 0;
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
            public void onHPDamage(int damage) {
                setHp(getHp() - damage);
            }

            @Override
            public void onPWRDamage(int damage) {
                setPower(getPower() - damage);
            }

            @Override
            public void onPureHPDamage(int damage) {
                setHp(getHp() - damage);
            }
        };

        damageCache.forEach(d -> d.visitBy(visitor));

        damageCache.clear();
    }
}