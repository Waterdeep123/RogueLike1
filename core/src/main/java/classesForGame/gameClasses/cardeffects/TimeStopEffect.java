package classesForGame.gameClasses.cardeffects;

import classesForGame.gameClasses.BattleContext;
import classesForGame.gameClasses.CardEffect;

public class TimeStopEffect extends CardEffect {

    @Override
    public void apply(BattleContext context) {

        // Skip enemy turn
        context.setSkipEnemyTurn(true);

        // Draw some cards to extend the combo
        context.getDeck().drawCards(3);

        // Gain some mana to continue casting
        context.getPlayer().gainMana(3);
    }
}
