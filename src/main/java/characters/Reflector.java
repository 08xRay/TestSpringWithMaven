package characters;

import annotations.AddToRandom;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@AddToRandom
public class Reflector extends Character {

    public Reflector() {
        super.setPower(4);
        super.setHp(16);
    }

    @Override
    public void kick(Character c) {
        System.out.println("Taste my mace!");
        final int val = ThreadLocalRandom.current().nextInt(1, super.getPower() + 1);
        System.out.println(this.getClass().getSimpleName() + " нанес " + val + " урона " + c.getClass().getSimpleName());
        Map<DamageType, Integer> damage =  new HashMap<>();
        damage.put(DamageType.HP, val);
        c.takeDamage(this, damage);
    }

    @Override
    public void takeDamage(Character from, Map<DamageType, Integer> dmg) {
        super.takeDamage(from, dmg);
        if (dmg.containsKey(DamageType.HP) && dmg.get(DamageType.HP) > 1) {
            System.out.println(this.getClass().getSimpleName() + ": fill the Power of Reflection!!!");
            int reflectedDamage = dmg.get(DamageType.HP) / 2;
            System.out.println(this.getClass().getSimpleName() + " нанес " + reflectedDamage + " урона " + from.getClass().getSimpleName());
            dmg.clear();
            dmg.put(DamageType.PURE_HP, reflectedDamage);
            from.takeDamage(this, dmg);
        }
    }
}
