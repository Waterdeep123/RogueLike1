package classesForGame.gameClasses.cardeffects;

import classesForGame.gameClasses.BattleContext;
import classesForGame.gameClasses.CardEffect;

public class HealEffect extends CardEffect {

    private int amount;

    public HealEffect(int amount) {
        this.amount = amount;
    }

    @Override
    public void apply(BattleContext context) {
        context.getPlayer().heal(amount);
    }
}
