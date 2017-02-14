package characters;

import annotations.AddToRandom;

import java.util.HashMap;
import java.util.Map;

@AddToRandom
public class Hobbit extends Character {

    public Hobbit() {
        super.setPower(0);
        super.setHp(3);
    }

    public void kick(Character c) {
        toCry();
        System.out.println(this.name + " нанес 0 урона " + c.name);
        Map<DamageType, Integer> damage =  new HashMap<>();
        damage.put(DamageType.HP, 0);
        c.takeDamage(this, damage);
    }

    private void toCry() {
        System.out.println(this.name + ":..mr frooudoouu weep, wee-ep");
    }
}
