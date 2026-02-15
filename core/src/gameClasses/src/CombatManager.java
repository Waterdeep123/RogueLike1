import java.util.ArrayList;
import java.util.List;

public class CombatManager {
    private List<Character> combatants = new ArrayList<>();
    // ... other turn management logic ...

    public void startGame() {
        Character player = new Character("Player", 100);
        Character enemy = new Character("Enemy", 50);
        combatants.add(player);
        combatants.add(enemy);

        // Apply a poison effect to the enemy (5 damage per turn for 3 turns)
        enemy.addEffect(new PoisonEffect(enemy, 5, 3));
    }

    public void nextTurn() {
        for (Character character : combatants) {
            if (character.getHealth() > 0) {
                // Apply any DoT effects at the beginning of the character's turn
                character.applyTurnEffects();
                // Then handle the character's main action (attack, use item, etc.)
                // ...
            }
        }
    }
}
