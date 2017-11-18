package manager.impl;

import context.Context;
import manager.Manager;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Stanislav Raytsin
 * @since 16.11.2017.
 */

public final class ManagerMap {
    private final Context<?> context;
    private final Map<Class<? extends Manager>, Manager> managers = new ConcurrentHashMap<>();

    public ManagerMap(@Nonnull Context<?> context) {
        this.context = context;
    }

    public int getManagersCount() {
        return managers.size();
    }

    @Nonnull
    @SuppressWarnings("unchecked")
    public <M extends Manager> M getManager(@Nonnull Class<M> managerClass) {
        return (M) managers.computeIfAbsent(managerClass, this::initDataManager);
    }

    @Nonnull
    @SuppressWarnings("unchecked")
    private <Instance extends Manager> Instance initDataManager(@Nonnull Class<? extends Manager> managerClass) {
        try {
            Class<? extends Manager> clazz = (Class<? extends Manager>) Class.forName(managerClass.getPackage().getName() + ".impl.Base" + managerClass.getSimpleName());
            Instance manager = (Instance) clazz.newInstance();
            manager.init(context);
            return manager;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }
}