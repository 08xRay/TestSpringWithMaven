package model.characters;

import annotations.AddToRandom;
import model.damage.Damage;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

@AddToRandom
@SuppressWarnings("unused")
public class King extends Character {

    public King() {
        super(ThreadLocalRandom.current().nextInt(5, 15 + 1), ThreadLocalRandom.current().nextInt(5, 15 + 1));
    }

    public void kick(Character c) {
        System.out.println("Don't make me laugh!");
        final int val = ThreadLocalRandom.current().nextInt(1, super.getPower() + 1);
        System.out.println(this.name + " нанес " + val + " урона " + c.name);
        c.takeDamage(this, Collections.singletonList(new Damage(val, Damage.DamageType.HP)));
    }

}
