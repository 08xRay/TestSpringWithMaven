package characters;

import annotations.AddToRandom;

import java.util.HashMap;
import java.util.Map;

@AddToRandom
public class Elf extends Character implements Eared {

    public Elf() {
        super(10,10);
    }

    public void kick(Character c) {
        Map<DamageType, Integer> damage =  new HashMap<DamageType, Integer>();
        if (c.getPower() < super.getPower()) {
            System.out.println("Ha-ha-ha, just die, fool");
            System.out.println(this.name + " собрался убить "+ c.name);
            damage.put(DamageType.HP, c.getHp());
            c.takeDamage(this, damage);
        } else {
            System.out.println("i will kill you, soon..");
            System.out.println(this.name + " нанес 0 урона " + c.name);
            damage.put(DamageType.PWR, 1);
            c.takeDamage(this, damage);
        }
    }
}
