package model.character;

import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("unused")
public class Knight extends AbstractCharacter {

    public Knight() {
        super(ThreadLocalRandom.current().nextInt(2, 12 + 1), ThreadLocalRandom.current().nextInt(2, 12 + 1));
    }

    public void kick(AbstractCharacter c) {
        System.out.println("God and my right!");
        final int val = ThreadLocalRandom.current().nextInt(1, super.getPower() + 1);
        System.out.println(this.name + " нанес " + val + " урона " + c.name);
//        c.takeDamage(this, Collections.singletonList(new DamageImpl(val, DamageImpl.DamageType.HP)));
    }
}
