package characters;

import annotations.AddToRandom;

import java.util.concurrent.ThreadLocalRandom;

@AddToRandom
public class Knight extends Character {

    public Knight() {
        super.setPower(ThreadLocalRandom.current().nextInt(2, 12 + 1));
        super.setHp(ThreadLocalRandom.current().nextInt(2, 12 + 1));
    }

    public void kick(Character c) {
        System.out.println("God and my right!");
        final int val = ThreadLocalRandom.current().nextInt(1, super.getPower() + 1);
        System.out.println(this.getClass().getSimpleName() + " нанес " + val + " урона " + c.getClass().getSimpleName());
        c.setHp(c.getHp() - val);
    }
}
