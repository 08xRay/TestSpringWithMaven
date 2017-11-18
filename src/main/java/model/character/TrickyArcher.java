package model.character;

import annotation.AddToRandom;

import java.util.concurrent.ThreadLocalRandom;

@AddToRandom
@SuppressWarnings("unused")
public class TrickyArcher extends AbstractCharacter {

    public TrickyArcher() {
        super(9, 2);
    }

    public void kick(AbstractCharacter c) {
        System.out.println("Right on the target!");
        final int val = ThreadLocalRandom.current().nextInt(1, super.getPower() * 2 + 1);
        System.out.println(this.name + " нанес " + val + " урона " + c.name);
//        c.takeDamage(this, Collections.singletonList(new DamageImpl(val, DamageImpl.DamageType.HP)));
    }

//    public void takeDamage(AbstractCharacter from, List<DamageImpl> dmg) {
//        if (ThreadLocalRandom.current().nextBoolean()) {
//            System.out.println(this.name + ": few...you missed!");
//        } else {
////            super.takeDamage(from, dmg);
//        }
//    }
}