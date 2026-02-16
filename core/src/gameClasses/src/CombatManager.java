
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CombatManager {
    private List<Object> combatants = new ArrayList<Object>();
    private ArrayList<Enemy> allEnemies = new ArrayList<Enemy>();
    // ... other turn management logic ...

    public CombatManager(Character player){
        startGame(player);
    }
    public void startGame(Character player) {
        combatants.add(player);
        initEnemies();
        Enemy randomEnemy = randomCommonEnemy();

        combatants.add(randomEnemy);

        // Apply a poison effect to the enemy (5 damage per turn for 3 turns)

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

    public void initEnemies(){
        Enemy Spider = new Enemy("Giant Spider", 10);
        allEnemies.add(Spider);
        Enemy Zombie = new Enemy("Zombie Warrior", 20);
        allEnemies.add(Zombie);
    }
    public Enemy randomCommonEnemy(){
        Random rand = new Random();
        int randomAction = rand.nextInt(allEnemies.size());
        return allEnemies.get(randomAction);
    }


}
