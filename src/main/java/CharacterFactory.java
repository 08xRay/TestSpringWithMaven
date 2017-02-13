import annotations.AddToRandom;
import characters.Character;
import org.reflections.Reflections;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class CharacterFactory  {

    private Object[] characters;

    public CharacterFactory() {
        characters = processDirectory(new File(System.getProperty("user.dir") + "/target/classes/",
                "characters/"));
    }


    public Character createCharacter() {
        if (characters == null || characters.length == 0)  return null;
        int random = ThreadLocalRandom.current().nextInt(0,  characters.length);
        try {
            Class<?> c = (Class<?>)characters[random];
            return (Character)c.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
           throw new RuntimeException();
        }
    }

    private Object[] processDirectory(File directory) {
        Reflections reflections = new Reflections(directory);
        Set<Class<? extends Character>> classes = reflections.getSubTypesOf(Character.class);
        Set<Class<? extends Character>> classesNeedToRemove = new HashSet<>();
        for (Class<? extends Character> c : classes) {
            if (!c.isAnnotationPresent(AddToRandom.class)) {
                classesNeedToRemove.add(c);
            }
        }
        classes.removeAll(classesNeedToRemove);
        return classes.toArray();
    }
}
