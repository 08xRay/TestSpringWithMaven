package model.character;


@SuppressWarnings("unused")
public class Orc extends AbstractCharacter {

    public Orc() {
        super(5, 8);
    }

    public void kick(AbstractCharacter c) {
        if (c instanceof Eared) {
            System.out.println("Yeess, i will crush your small tiny head, eared elf");
            System.out.println(this.name + " нанес " + getPower() * 2 + " урона "+ c.name);
//            c.takeDamage(this, Collections.singletonList(new DamageImpl(getPower() * 2, DamageImpl.DamageType.HP)));
        } else {
            System.out.println("braAAaghhh!!");
            System.out.println(this.name + " нанес " + getPower() + " урона "+ c.name);
//            c.takeDamage(this, Collections.singletonList(new DamageImpl(getPower(), DamageImpl.DamageType.HP)));
        }
    }
}
