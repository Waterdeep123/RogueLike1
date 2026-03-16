package classesForGame.gameClasses.cardeffects;

import classesForGame.gameClasses.BattleContext;
import classesForGame.gameClasses.CardEffect;

public class XEffect extends CardEffect {

    private CardEffect effectPerMana;
    private int bonus;

    public XEffect(CardEffect effectPerMana, int bonus) {
        this.effectPerMana = effectPerMana;
        this.bonus = bonus;
    }

    @Override
    public void apply(BattleContext context) {
        int manaSpent = context.getPlayer().spendAllMana();

        for (int i = 0; i < manaSpent; i++) {
            effectPerMana.apply(context);
        }
    }
}
