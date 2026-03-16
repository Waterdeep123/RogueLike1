package classesForGame.entities;

import java.util.HashMap;
import java.util.Map;

import classesForGame.enums.DamageType;
import classesForGame.enums.EnemyIntent;
import classesForGame.enums.StatusEffectType;

public class Enemy {

    private String name;
    private int maxHealth;
    private int health;
    private int block;
    private EnemyIntent intent;
    private int intentValue;

    private Map<StatusEffectType, Integer> statusEffects;

    public Enemy(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.block = 0;
        this.statusEffects = new HashMap<>();
    }

    public void takeDamage(int damage, DamageType type) {
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

    public void gainBlock(int amount) {
        block += amount;
    }

    public void applyStatus(StatusEffectType effect, int amount) {
        int current = statusEffects.getOrDefault(effect, 0);
        statusEffects.put(effect, current + amount);
    }

    public int getStatusAmount(StatusEffectType effect) {
        return statusEffects.getOrDefault(effect, 0);
    }

    public boolean isDead() {
        return health <= 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getBlock() {
        return block;
    }

    public Map<StatusEffectType, Integer> getStatusEffects() {
        return statusEffects;
    }
}
