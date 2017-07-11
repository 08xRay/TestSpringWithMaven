package characters;

import annotations.AddToRandom;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@AddToRandom
public class Knight extends Character {

    public Knight() {
        super(ThreadLocalRandom.current().nextInt(2, 12 + 1), ThreadLocalRandom.current().nextInt(2, 12 + 1));
    }

    public void kick(Character c) {
        System.out.println("God and my right!");
        final int val = ThreadLocalRandom.current().nextInt(1, super.getPower() + 1);
        System.out.println(this.name + " нанес " + val + " урона " + c.name);
        Map<DamageType, Integer> damage =  new HashMap<>();
        damage.put(DamageType.HP, val);
        c.takeDamage(this, damage);
    }
}
