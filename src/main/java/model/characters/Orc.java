package model.characters;


import annotations.AddToRandom;
import model.damage.Damage;

import java.util.Collections;

@AddToRandom
@SuppressWarnings("unused")
public class Orc extends Character {

    public Orc() {
        super(5, 8);
    }

    @Override
    public void kick(Character c) {
        if (c instanceof Eared) {
            System.out.println("Yeess, i will crush your small tiny head, eared elf");
            System.out.println(this.name + " нанес " + getPower() * 2 + " урона "+ c.name);
            c.takeDamage(this, Collections.singletonList(new Damage(getPower() * 2, Damage.DamageType.HP)));
        } else {
            System.out.println("braAAaghhh!!");
            System.out.println(this.name + " нанес " + getPower() + " урона "+ c.name);
            c.takeDamage(this, Collections.singletonList(new Damage(getPower(), Damage.DamageType.HP)));
        }
    }
}
