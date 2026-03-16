package classesForGame.gameClasses.cardeffects;

import classesForGame.gameClasses.BattleContext;
import classesForGame.gameClasses.CardEffect;

public class DrawCardEffect extends CardEffect {

    private int amount;

    public DrawCardEffect(int amount) {
        this.amount = amount;
    }

    @Override
    public void apply(BattleContext context) {
        context.getDeck().drawCards(amount);
    }
}
