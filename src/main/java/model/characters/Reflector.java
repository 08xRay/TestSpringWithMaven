package model.characters;

import annotations.AddToRandom;
import model.damage.Damage;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@AddToRandom
@SuppressWarnings("unused")
public class Reflector extends Character {

    public Reflector() {
        super(4, 16);
    }

    @Override
    public void kick(Character c) {
        System.out.println("Taste my mace!");
        final int val = ThreadLocalRandom.current().nextInt(1, super.getPower() + 1);
        System.out.println(this.name + " нанес " + val + " урона " + c.name);
        c.takeDamage(this, Collections.singletonList(new Damage(val, Damage.DamageType.HP)));
    }

    @Override
    public void takeDamage(Character from, List<Damage> dmg) {
        super.takeDamage(from, dmg);
        from.takeDamage(this, dmg.stream()
                .filter(d -> d.getType() == Damage.DamageType.HP && d.getCount() > 1)
                .map(d -> {
                    System.out.println(this.name + ": fill the Power of Reflection!!!");
                    int reflectedDamage = d.getCount() / 2;
                    System.out.println(this.name + " нанес " + reflectedDamage + " урона " + from.name);
                    return new Damage(reflectedDamage, Damage.DamageType.PURE_HP); })
                .collect(Collectors.toList()));
    }
}
