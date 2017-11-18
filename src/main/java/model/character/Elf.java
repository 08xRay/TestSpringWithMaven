package model.character;

@SuppressWarnings("unused")
public class Elf extends AbstractCharacter implements Eared {

    public Elf() {
        super(10,10);
    }

    public void kick(AbstractCharacter ch) {
//        if (ch.getPower() < super.getPower()) {
//            System.out.println("Ha-ha-ha, just die, fool");
//            System.out.println(this.name + " собрался убить " + ch.name);
//            ch.takeDamage(this, Collections.singletonList(new DamageImpl(ch.getHP(), DamageImpl.DamageType.PURE_HP)));
//        } else {
//            System.out.println("i will kill you, soon..");
//            System.out.println(this.name + " нанес 0 урона " + ch.name);
//            ch.takeDamage(this, Collections.singletonList(new DamageImpl(1, DamageImpl.DamageType.PWR)));
//        }
    }
}
