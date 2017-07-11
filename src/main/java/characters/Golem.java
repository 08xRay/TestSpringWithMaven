package characters;

import annotations.AddToRandom;

import java.util.HashMap;
import java.util.Map;

@AddToRandom
public class Golem extends Character {

    private int counter;

    public Golem() {
        super(1, Integer.MAX_VALUE);
        counter = 7;
    }
    @Override
    public void setPower(int power) {
        // just ignore it
    }

    @Override
    public void setHp(int hp) {
        //just ignore it
    }

    @Override
    public void kick(Character c) {
        System.out.println("I'm Golem, fear me!");
        System.out.println(this.name + " нанес " + getPower() + " урона " + c.name);
        Map<DamageType, Integer> damage =  new HashMap<>();
        damage.put(DamageType.HP, getPower());
        c.takeDamage(this, damage);
    }

    @Override
    public void takeDamage(Character from, Map<DamageType, Integer> dmg) {
        if (this.counter-- > 0)
            return;
        super.setHp(0);
    }
}
