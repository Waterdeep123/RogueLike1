package classesForGame.gameClasses.cardeffects;

import classesForGame.gameClasses.BattleContext;
import classesForGame.gameClasses.CardEffect;

public class GainManaEffect extends CardEffect {

    private int amount;

    public GainManaEffect(int amount) {
        this.amount = amount;
    }

    @Override
    public void apply(BattleContext context) {
        context.getPlayer().gainMana(amount);
    }
}
