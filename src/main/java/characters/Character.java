package characters;

import org.fluttercode.datafactory.impl.DataFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Character implements CharactersBehavior, Serializable {
    private static DataFactory dataFactory;

    public final String name;
    private int power;
    private int hp;
    private Map<DamageType, Integer> damage;

    public Character() {
        if (Character.dataFactory == null) {
            dataFactory = new DataFactory();
        }
        final int rV = ThreadLocalRandom.current().nextInt(1, 10+1);
        for (int i = 0; i < rV; i++) dataFactory.getLastName();
        name = new StringBuilder(this.getClass().getSimpleName()).append(" ").append(dataFactory.getLastName()).toString();
    }

    public Character(int power, int hp) {
        this();
        this.power = power;
        this.hp = hp;
    }

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

    @Override
    public void takeDamage(Character from, Map<DamageType, Integer> dmg) {
        if (damage == null) { damage = new HashMap<>(); }
        for (DamageType key : dmg.keySet()) {
            if (damage.containsKey(key)) {
                Integer val = damage.get(key);
                damage.put(key, val + dmg.get(key));
            } else {
                damage.put(key, dmg.get(key));
            }
        }
    }

    public void applyChanges() {
        if (damage == null) return;
        if (damage.containsKey(DamageType.HP)) {
            setHp(getHp() - damage.get(DamageType.HP));

        }
        if (damage.containsKey(DamageType.PWR)) {
            setPower(getPower() - damage.get(DamageType.PWR));
        }
        if (damage.containsKey(DamageType.PURE_HP)) {
            setHp(getHp() - damage.get(DamageType.PURE_HP));
        }
        damage.clear();
    }

}
