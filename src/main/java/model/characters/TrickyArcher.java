package model.characters;

import annotations.AddToRandom;
import model.damage.Damage;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@AddToRandom
@SuppressWarnings("unused")
public class TrickyArcher extends Character {

    public TrickyArcher() {
        super(9, 2);
    }

    @Override
    public void kick(Character c) {
        System.out.println("Right on the target!");
        final int val = ThreadLocalRandom.current().nextInt(1, super.getPower() * 2 + 1);
        System.out.println(this.name + " нанес " + val + " урона " + c.name);
        c.takeDamage(this, Collections.singletonList(new Damage(val, Damage.DamageType.HP)));
    }

    @Override
    public void takeDamage(Character from, List<Damage> dmg) {
        if (ThreadLocalRandom.current().nextBoolean()) {
            System.out.println(this.name + ": few...you missed!");
        } else {
            super.takeDamage(from, dmg);
        }
    }
}