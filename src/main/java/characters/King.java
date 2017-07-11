package characters;

import annotations.AddToRandom;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@AddToRandom
public class King extends Character {

    public King() {
        super(ThreadLocalRandom.current().nextInt(5, 15 + 1), ThreadLocalRandom.current().nextInt(5, 15 + 1));
    }

    public void kick(Character c) {
        System.out.println("Don't make me laugh!");
        final int val = ThreadLocalRandom.current().nextInt(1, super.getPower() + 1);
        System.out.println(this.name + " нанес " + val + " урона " + c.name);
        Map<DamageType, Integer> damage =  new HashMap<>();
        damage.put(DamageType.HP, val);
        c.takeDamage(this, damage);
    }

}
