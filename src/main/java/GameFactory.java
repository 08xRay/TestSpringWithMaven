import annotations.AddToRandom;
import org.reflections.Reflections;

import java.io.File;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameFactory {

    private Map<String, Object[]> classes;
    private final File directory;

    public GameFactory(final File directory) {
        this.directory = directory;
        classes = new HashMap<>();
    }

    @SuppressWarnings("unchecked")
    public <T> T createRandomObject(Class<T> c) {
        List<Class<T>> randomObjects;
        Object[] objects;
        if (!classes.containsKey(c.getSimpleName())) {
            objects = processDirectory(directory, c);
            classes.put(c.getSimpleName(), objects);
        } else {
            objects = classes.get(c.getSimpleName());
        }
        randomObjects = new ArrayList<>(objects.length);
        for (Object z : objects) {
            Class<T> value = (Class<T>) z;
            if (value.isAnnotationPresent(AddToRandom.class)) randomObjects.add(value);
        }
        int random = ThreadLocalRandom.current().nextInt(0,  randomObjects.size());
        try {
            Class<T> randomObject = randomObjects.get(random);
            return randomObject.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
           throw new RuntimeException();
        }
    }

    private <T> Object[] processDirectory(final File directory, final Class<T> type) {
        Reflections reflections = new Reflections(directory);
        Set<Class<? extends T>> classes = reflections.getSubTypesOf(type);
        return classes.toArray();
    }
}
