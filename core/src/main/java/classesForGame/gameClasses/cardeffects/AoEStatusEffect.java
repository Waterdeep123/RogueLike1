package classesForGame.gameClasses.cardeffects;

import classesForGame.entities.Enemy;
import classesForGame.enums.StatusEffectType;
import classesForGame.gameClasses.BattleContext;
import classesForGame.gameClasses.CardEffect;

public class AoEStatusEffect extends CardEffect {

    private StatusEffectType statusEffect;
    private int amount;

    public AoEStatusEffect(StatusEffectType statusEffect, int amount) {
        this.statusEffect = statusEffect;
        this.amount = amount;
    }

    @Override
    public void apply(BattleContext context) {
        for (Enemy enemy : context.getEnemies()) {
            if (!enemy.isDead()) {
                enemy.applyStatus(statusEffect, amount);
            }
        }
    }
}
