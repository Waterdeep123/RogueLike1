package classesForGame.gameClasses.cardeffects;

import classesForGame.enums.DamageType;
import classesForGame.gameClasses.BattleContext;
import classesForGame.gameClasses.CardEffect;

public class HalfLifeSacrificeEffect extends CardEffect {

    @Override
    public void apply(BattleContext context) {

        int currentHealth = context.getPlayer().getHealth();
        int sacrifice = currentHealth / 2;

        context.getPlayer().takeDamage(sacrifice);

        if (context.getTargetEnemy() != null) {
            context.getTargetEnemy().takeDamage(sacrifice * 3, DamageType.DARK);
        }
    }
}
