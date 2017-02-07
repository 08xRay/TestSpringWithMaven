package characters;

import annotations.AddToRandom;

import java.util.concurrent.ThreadLocalRandom;

@AddToRandom
public class King extends Character {

    public King() {
        super.setPower(ThreadLocalRandom.current().nextInt(5, 15 + 1));
        super.setHp(ThreadLocalRandom.current().nextInt(5, 15 + 1));
    }

    public void kick(Character c) {
        System.out.println("Don't make me laugh!");
        final int val = ThreadLocalRandom.current().nextInt(1, super.getPower() + 1);
        System.out.println(this.getClass().getSimpleName() + " нанес " + val + " урона " + c.getClass().getSimpleName());
        c.setHp(c.getHp() - val);
    }

}
