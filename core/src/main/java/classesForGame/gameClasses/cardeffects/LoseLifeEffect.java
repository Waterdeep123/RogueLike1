package classesForGame.gameClasses.cardeffects;

import classesForGame.gameClasses.BattleContext;
import classesForGame.gameClasses.CardEffect;

public class LoseLifeEffect extends CardEffect {

    private int amount;

    public LoseLifeEffect(int amount) {
        this.amount = amount;
    }

    @Override
    public void apply(BattleContext context) {
        context.getPlayer().takeDamage(amount);
    }
}
