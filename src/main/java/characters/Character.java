package characters;

public abstract class Character implements CharactersBehavior {
    private int power;
    private int hp;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = (power > 0) ? power : 0;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = (hp > 0) ? hp : 0;
    }

    public boolean isAlive() {
        return getHp() > 0;
    }
}
