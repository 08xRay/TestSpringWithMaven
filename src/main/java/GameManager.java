import characters.Character;

public class GameManager {

    public static void main(String[] args) {
        Character c1 = CharacterFactory.createCharacter();
        Character c2 = CharacterFactory.createCharacter();
        fight(c1, c2);
    }

    public static void fight(Character c1, Character c2) {
        while (c1.isAlive()){
            c1.kick(c2);
            System.out.println(c1.getClass().getSimpleName() + " " + c1.getHp() + "hp");
            System.out.println(c2.getClass().getSimpleName() + " " + c2.getHp() + "hp");
            if (c2.isAlive()) {
                c2.kick(c1);
                System.out.println(c1.getClass().getSimpleName() + " " + c1.getHp() + "hp");
                System.out.println(c2.getClass().getSimpleName() + " " + c2.getHp() + "hp");
            } else {
                break;
            }
        }
    }
}
