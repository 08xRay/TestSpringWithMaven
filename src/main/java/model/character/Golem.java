package model.character;

@SuppressWarnings("unused")
public class Golem extends AbstractCharacter {

    private int counter;

    public Golem() {
        super(1, Integer.MAX_VALUE);
        counter = 7;
    }

    public void setPower(int power) {
        // just ignore it
    }

    public void setHp(int hp) {
        //just ignore it
    }

    public void kick(AbstractCharacter c) {
//        System.out.println("I'm Golem, fear me!");
//        System.out.println(this.name + " нанес " + getPower() + " урона " + c.name);
//        c.takeDamage(this, Collections.singletonList(new DamageImpl(getPower(), DamageImpl.DamageType.HP)));
    }

//    public void takeDamage(AbstractCharacter from, List<DamageImpl> dmg) {
//        if (this.counter-- > 0)
//            return;
//        super.setHp(0);
//    }
}
