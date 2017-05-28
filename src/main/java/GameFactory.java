import annotations.AddToRandom;
import org.reflections.Reflections;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public final class GameFactory {
    private final Map<String, Object[]> classes;
    private final File directory;

    public GameFactory(final File directory) {
        this.directory = directory;
        this.classes = new HashMap<>();
    }

    @SuppressWarnings("unchecked")
    public <T> T createRandomObject(final Class<T> c) {
        final Object[] objects = classes.computeIfAbsent(c.getSimpleName(), (ignored) -> processDirectory(directory, c));
        final List<Class<T>> randomObjects = new ArrayList<>(objects.length);

        Arrays.stream(objects)
                .map(obj -> (Class<T>)obj)
                .filter(clazz -> clazz.isAnnotationPresent(AddToRandom.class))
                .forEach(randomObjects::add);

        final int random = ThreadLocalRandom.current().nextInt(0,  randomObjects.size());
        try {
            return randomObjects.get(random).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
           throw new RuntimeException(e);
        }
    }

    private <T> Object[] processDirectory(final File directory, final Class<T> type) {
        return new Reflections(directory).getSubTypesOf(type).toArray();
    }
}