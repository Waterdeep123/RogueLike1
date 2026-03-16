package classesForGame.gameClasses.cardeffects;

import classesForGame.entities.Enemy;
import classesForGame.enums.DamageType;
import classesForGame.gameClasses.BattleContext;
import classesForGame.gameClasses.CardEffect;

public class AoEDamageEffect extends CardEffect {

    private int damage;
    private DamageType damageType;

    public AoEDamageEffect(int damage, DamageType damageType) {
        this.damage = damage;
        this.damageType = damageType;
    }

    @Override
    public void apply(BattleContext context) {
        for (Enemy enemy : context.getEnemies()) {
            if (!enemy.isDead()) {
                enemy.takeDamage(damage, damageType);
            }
        }
    }
}
