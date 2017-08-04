package model.characters;

import annotations.AddToRandom;
import model.damage.Damage;

import java.util.Collections;
import java.util.List;

@AddToRandom
@SuppressWarnings("unused")
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
        c.takeDamage(this, Collections.singletonList(new Damage(getPower(), Damage.DamageType.HP)));
    }

    @Override
    public void takeDamage(Character from, List<Damage> dmg) {
        if (this.counter-- > 0)
            return;
        super.setHp(0);
    }
}
