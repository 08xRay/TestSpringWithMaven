import characters.Character;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameManager {

    public static void main(String[] args) {
        Character c1 = CharacterFactory.createCharacter();
        Character c2 = CharacterFactory.createCharacter();
        fight(c1, c2);
    }

    public static void fight(Character c1, Character c2) {
        System.out.println("Начало боя:");
        logStatus(c1, c2);
        while (c1.isAlive() && c2.isAlive()) {
            // расчет урона
            c1.kick(c2);
            c2.kick(c1);
            // сохраняем изменения
            c1.applyChanges();
            c2.applyChanges();

            logStatus(c1, c2);

            if (c1.getPower() == 0 && c2.getPower() == 0) {
                System.out.println("Войны упорно сражались до самой ночи, но никто так и не смог победить... ничья!");
                break;
            }
        }
    }

    private static void logStatus(Character c1, Character c2) {
        System.out.println("==========================================");
        System.out.println(c1.getClass().getSimpleName() + " статус: " + c1.getHp() + " hp, " + c1.getPower() + " pwr.");
        System.out.println(c2.getClass().getSimpleName() + " статус: " + c2.getHp() + " hp, " + c2.getPower() + " pwr.");
        System.out.println("------------------------------------------");
    }

    private static Character copyChatacter(Character c) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream ous = new ObjectOutputStream(baos);
            ous.writeObject(c);
            ous.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Character clone = c.getClass().cast(ois.readObject());
            return clone;
        } catch (Exception e) {throw new RuntimeException();}
    }
}
