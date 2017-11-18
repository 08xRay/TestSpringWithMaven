package model.character;

import annotation.AddToRandom;

import java.util.concurrent.ThreadLocalRandom;

@AddToRandom
@SuppressWarnings("unused")
public class Reflector extends AbstractCharacter {

    public Reflector() {
        super(2, 8);
    }

    public void kick(AbstractCharacter c) {
        System.out.println("Taste my mace!");
        final int val = ThreadLocalRandom.current().nextInt(1, super.getPower() + 1);
        System.out.println(this.name + " нанес " + val + " урона " + c.name);
//        c.takeDamage(this, Collections.singletonList(new DamageImpl(val, DamageImpl.DamageType.HP)));
    }

//    public void takeDamage(AbstractCharacter from, List<DamageImpl> dmg) {
//        super.takeDamage(from, dmg);
//        from.takeDamage(this, dmg.stream()
//                .filter(d -> d.getType() == DamageImpl.DamageType.HP && d.getCount() > 1)
//                .map(d -> {
//                    System.out.println(this.name + ": fill the Power of Reflection!!!");
//                    int reflectedDamage = d.getCount() / 2;
//                    System.out.println(this.name + " нанес " + reflectedDamage + " урона " + from.name);
//                    return new DamageImpl(reflectedDamage, DamageImpl.DamageType.PURE_HP); })
//                .collect(Collectors.toList()));
//    }
}
