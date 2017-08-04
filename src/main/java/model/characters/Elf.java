package model.characters;

import annotations.AddToRandom;
import model.damage.Damage;

import java.util.Collections;

@AddToRandom
@SuppressWarnings("unused")
public class Elf extends Character implements Eared {

    public Elf() {
        super(10,10);
    }

    public void kick(Character c) {
        if (c.getPower() < super.getPower()) {
            System.out.println("Ha-ha-ha, just die, fool");
            System.out.println(this.name + " собрался убить " + c.name);
            c.takeDamage(this, Collections.singletonList(new Damage(c.getHp(), Damage.DamageType.PURE_HP)));
        } else {
            System.out.println("i will kill you, soon..");
            System.out.println(this.name + " нанес 0 урона " + c.name);
            c.takeDamage(this, Collections.singletonList(new Damage(1, Damage.DamageType.PWR)));
        }
    }
}
