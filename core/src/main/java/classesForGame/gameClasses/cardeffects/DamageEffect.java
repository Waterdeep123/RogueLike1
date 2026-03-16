package classesForGame.gameClasses.cardeffects;

import classesForGame.enums.DamageType;
import classesForGame.gameClasses.BattleContext;
import classesForGame.gameClasses.CardEffect;

public class DamageEffect extends CardEffect {

    private int damage;
    private DamageType damageType;

    public DamageEffect(int damage, DamageType damageType) {
        this.damage = damage;
        this.damageType = damageType;
    }

    @Override
    public void apply(BattleContext context) {
        if (context.getTargetEnemy() != null) {
            context.getTargetEnemy().takeDamage(damage, damageType);
        }
    }
}
