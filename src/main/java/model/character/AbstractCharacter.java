package model.character;


import model.stats.Onomastics;
import model.stats.Power;
import model.stats.Vitality;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.ApplicationContext;

import javax.annotation.Nonnull;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractCharacter implements Power<Integer>, Vitality<Integer>, Onomastics<String> {
    private static final DataFactory dataFactory = new DataFactory();
    public final String name;
    private int power;
    private int hp;

    public static class Builder {
        private final ApplicationContext context;

        public Builder(@Nonnull ApplicationContext context) {
            this.context = context;
        }

        @Nonnull
        public AbstractCharacter buildRandomImplInstance() {
            String[] beanNamesForType = context.getBeanNamesForType(AbstractCharacter.class);
            int index = ThreadLocalRandom.current().nextInt(beanNamesForType.length);
            return (AbstractCharacter)context.getBean(beanNamesForType[index]);
        }
    }

    private AbstractCharacter() {
        final int rV = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        for (int i = 0; i < rV; i++) dataFactory.getLastName();
        name = new StringJoiner(" ").add(this.getClass().getSimpleName()).add(dataFactory.getLastName()).toString();
    }

    protected AbstractCharacter(int power, int hp) {
        this();
        this.power = power;
        this.hp = hp;
    }

    @Override
    public void setPower(@Nonnull Integer power) {
        this.power = (power > 0) ? power : 0;
    }

    @Nonnull
    @Override
    public Integer getPower() {
        return power;
    }
    
    @Override
    public void setHP(@Nonnull Integer hp) {
        this.hp = (hp > 0) ? hp : 0;
    }

    @Nonnull
    @Override
    public Integer getHP() {
        return hp;
    }

    @Override
    public boolean isAlive() {
        return getHP() > 0;
    }

    @Nonnull
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName()
                + " ["
                + "HP:" + getHP() + " "
                + "PWR:" + getPower() + " "
                + "Alive:" + isAlive()
                + "]";
    }
}