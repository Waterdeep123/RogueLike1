package classesForGame.gameClasses.cardeffects;

import classesForGame.gameClasses.BattleContext;
import classesForGame.gameClasses.CardEffect;

public class SetHealthEffect extends CardEffect {

    private int health;

    public SetHealthEffect(int health) {
        this.health = health;
    }

    @Override
    public void apply(BattleContext context) {
        context.getPlayer().setHealth(health);
    }
}
