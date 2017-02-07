package characters;

import annotations.AddToRandom;

import java.util.HashMap;
import java.util.Map;

@AddToRandom
public class Elf extends Character implements Eared {

    public Elf() {
        super.setPower(10);
        super.setHp(10);
    }

    public void kick(Character c) {
        Map<DamageType, Integer> damage =  new HashMap<DamageType, Integer>();
        if (c.getPower() < super.getPower()) {
            System.out.println("Ha-ha-ha, just die, fool");
            System.out.println(this.getClass().getSimpleName() + " убил "+ c.getClass().getSimpleName());
            damage.put(DamageType.HP, c.getHp());
            c.takeDamage(this, damage);
        } else {
            System.out.println("i will kill you, soon..");
            System.out.println(this.getClass().getSimpleName() + " нанес 0 урона " + c.getClass().getSimpleName());
            damage.put(DamageType.PWR, 1);
            c.takeDamage(this, damage);
        }
    }
}
