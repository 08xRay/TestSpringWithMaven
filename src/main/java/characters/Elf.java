package characters;

import annotations.AddToRandom;

@AddToRandom
public class Elf extends Character {

    public Elf() {
        super.setPower(10);
        super.setHp(10);
    }

    public void kick(Character c) {
        if (c.getPower() < super.getPower()) {
            System.out.println("Ha-ha-ha, just die, fool");
            System.out.println(this.getClass().getSimpleName() + " убил "+ c.getClass().getSimpleName());
            c.setHp(0);
        } else {
            System.out.println("i will kill you, soon..");
            System.out.println(this.getClass().getSimpleName() + " нанес 0 урона " + c.getClass().getSimpleName());
            c.setPower(c.getPower() - 1);
        }
    }
}
