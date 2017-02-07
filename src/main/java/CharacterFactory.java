import annotations.AddToRandom;
import characters.Character;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CharacterFactory  {

    private static ArrayList<Class<?>> characters = processDirectory(new File(System.getProperty("user.dir")+"/target/classes/",
            "characters/"), "characters");

    public static Character createCharacter() {
        if (characters.isEmpty())  return null;
        int random = ThreadLocalRandom.current().nextInt(0,  characters.size());
        Class<?> c = characters.get(random);
        try {
            return (Character)c.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
           throw new RuntimeException();
        }
    }
    private static ArrayList<Class<?>> processDirectory(File directory, String pkgname) {

        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();

        //System.out.println("Reading Directory '" + directory + "'");

        // Get the list of the files contained in the package
        String[] files = directory.list();
        for (int i = 0; i < files.length; i++) {
            String fileName = files[i];
            String className = null;

            // we are only interested in .class files
            if (fileName.endsWith(".class")) {
                // removes the .class extension
                className = pkgname + '.' + fileName.substring(0, fileName.length() - 6);
            }

            //System.out.println("FileName '" + fileName + "'  =>  class '" + className + "'");

            if (className != null) {
                Class<?> cl = loadClass(className);
                if(cl.getAnnotation(AddToRandom.class) == null) continue;
                classes.add(loadClass(className));
            }
        }
        return classes;
    }

    private static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException("Unexpected ClassNotFoundException loading class '" + className + "'");
        }
    }
}
