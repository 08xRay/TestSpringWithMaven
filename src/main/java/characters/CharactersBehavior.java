package characters;

import java.util.Map;

public interface CharactersBehavior {
    void kick(Character c);
    boolean isAlive();
    void takeDamage(Character from, Map<DamageType, Integer> damage);
    void applyChanges();
}
