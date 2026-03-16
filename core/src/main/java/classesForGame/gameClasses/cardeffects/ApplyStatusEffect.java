package classesForGame.gameClasses.cardeffects;

import classesForGame.enums.StatusEffectType;
import classesForGame.gameClasses.BattleContext;
import classesForGame.gameClasses.CardEffect;

public class ApplyStatusEffect extends CardEffect {

    private StatusEffectType effect;
    private int amount;

    public ApplyStatusEffect(StatusEffectType effect, int amount) {
        this.effect = effect;
        this.amount = amount;
    }

    @Override
    public void apply(BattleContext context) {
        if (context.getTargetEnemy() != null) {
            context.getTargetEnemy().applyStatus(effect, amount);
        }
    }
}
