package model.characters;

import annotations.AddToRandom;

import java.util.Collections;

@AddToRandom
@SuppressWarnings("unused")
public class Hobbit extends Character {

    public Hobbit() {
        super(0, 3);
    }

    public void kick(Character c) {
        toCry();
        System.out.println(this.name + " нанес 0 урона " + c.name);
        c.takeDamage(this, Collections.emptyList());
    }

    private void toCry() {
        System.out.println(this.name + ":..mr frooudoouu weep, wee-ep");
    }
}
