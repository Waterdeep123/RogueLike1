package classesForGame.gameClasses.cardeffects;

import classesForGame.enums.StatusEffectType;
import classesForGame.gameClasses.BattleContext;
import classesForGame.gameClasses.CardEffect;

public class ApplyStatusToSelfEffect extends CardEffect {

    private StatusEffectType statusEffect;
    private int amount;

    public ApplyStatusToSelfEffect(StatusEffectType statusEffect, int amount) {
        this.statusEffect = statusEffect;
        this.amount = amount;
    }

    @Override
    public void apply(BattleContext context) {
        context.getPlayer().applyStatus(statusEffect, amount);
    }
}
