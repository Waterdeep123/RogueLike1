package classesForGame.entities;
import classesForGame.gameClasses.Deck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import classesForGame.enums.StatusEffectType;
import classesForGame.gameClasses.relics.Relic;

public class Player {

    private String name;
    private int maxHealth;
    private int health;
    private int block;

    private int mana;
    private int maxMana;
    private Deck deck;
    private Map<StatusEffectType, Integer> statusEffects;
    private ArrayList<Relic> relics;


    public Player(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.block = 0;

        this.mana = 0;
        this.maxMana = 0;
        this.statusEffects = new HashMap<>();
        this.relics = new ArrayList<>();
    }

    public void startCombat() {
        maxMana = 1;
        mana = maxMana;
        block = 0;
    }

    public void startTurn() {
        if (maxMana < 10) {
            maxMana++;
        }
        mana = maxMana;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public void heal(int amount) {
        health += amount;

        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public void endTurn() {

        // Trigger relic effects that happen at end of turn
        for (Relic relic : relics) {
            relic.onTurnEnd(this);
        }

        // Discard all cards in hand
        deck.discardHand();
    }

    public boolean canPlayCard(int cost) {
        return mana >= cost;
    }

    public boolean spendMana(int amount) {
        if (mana >= amount) {
            mana -= amount;
            return true;
        }
        return false;
    }

    public void gainBlock(int amount) {
        block += amount;
    }

    public void takeDamage(int damage) {
        if (block >= damage) {
            block -= damage;
        } else {
            int remainingDamage = damage - block;
            block = 0;
            health -= remainingDamage;

            if (health < 0) {
                health = 0;
            }
        }
    }

    public int spendAllMana() {
        int spent = mana;
        mana = 0;
        return spent;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getBlock() {
        return block;
    }

    public int getMana() {
        return mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void gainMana(int amount) {
        mana += amount;
    }

    public void applyStatus(StatusEffectType effect, int amount) {
        int current = statusEffects.getOrDefault(effect, 0);
        statusEffects.put(effect, current + amount);
    }

    public int getStatusAmount(StatusEffectType effect) {
        return statusEffects.getOrDefault(effect, 0);
    }

    public Map<StatusEffectType, Integer> getStatusEffects() {
        return statusEffects;
    }
}
