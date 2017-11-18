package manager.impl;

import context.Context;
import manager.FightManager;
import model.character.AbstractCharacter;

import javax.annotation.Nonnull;

/**
 * @author Stanislav Raytsin
 * @since 18.11.2017.
 */
public final class BaseFightManager implements FightManager<AbstractCharacter> {
    private Context<AbstractCharacter> context;

    BaseFightManager() {
        // only used by the ManagerMap.class
    }

    public BaseFightManager(@Nonnull Context<AbstractCharacter> context) {
        this.context = context;
    }

    @Override
    public void fight(@Nonnull AbstractCharacter v1,@Nonnull AbstractCharacter v2) {
        System.out.println(this.getClass().getSimpleName() + " called fight method");
        context.getStrategy().execute(v1, v2);
    }

    @Override
    public void init(@Nonnull Context<AbstractCharacter> context) {
        this.context = context;
    }

    @Nonnull
    @Override
    public Context<AbstractCharacter> getContext() {
        return context;
    }
}
