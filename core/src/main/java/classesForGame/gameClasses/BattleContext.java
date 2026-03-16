package classesForGame.gameClasses;

import com.badlogic.gdx.utils.Array;

import classesForGame.entities.Enemy;
import classesForGame.entities.Player;

public class BattleContext {

    private Player player;
    private Enemy targetEnemy;
    private Array<Enemy> enemies;
    private Deck deck;
    private boolean skipEnemyTurn;

    public BattleContext(Player player, Enemy targetEnemy, Array<Enemy> enemies, Deck deck) {
        this.player = player;
        this.targetEnemy = targetEnemy;
        this.enemies = enemies;
        this.deck = deck;
    }

    public boolean isSkipEnemyTurn() {
        return skipEnemyTurn;
    }

    public void setSkipEnemyTurn(boolean skipEnemyTurn) {
        this.skipEnemyTurn = skipEnemyTurn;
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getTargetEnemy() {
        return targetEnemy;
    }

    public Array<Enemy> getEnemies() {
        return enemies;
    }

    public Deck getDeck() {
        return deck;
    }
}
