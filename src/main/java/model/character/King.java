package model.character;

import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("unused")
public class King extends AbstractCharacter {

    public King() {
        super(ThreadLocalRandom.current().nextInt(5, 15 + 1), ThreadLocalRandom.current().nextInt(5, 15 + 1));
    }

    public void kick(AbstractCharacter c) {
        System.out.println("Don't make me laugh!");
        final int val = ThreadLocalRandom.current().nextInt(1, super.getPower() + 1);
        System.out.println(this.name + " нанес " + val + " урона " + c.name);
//        c.takeDamage(this, Collections.singletonList(new DamageImpl(val, DamageImpl.DamageType.HP)));
    }

}
