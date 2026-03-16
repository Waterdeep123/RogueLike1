package classesForGame.gameClasses.cardeffects;

import classesForGame.gameClasses.BattleContext;
import classesForGame.gameClasses.CardEffect;

public class BlockEffect extends CardEffect {

    private int blockAmount;

    public BlockEffect(int blockAmount) {
        this.blockAmount = blockAmount;
    }

    @Override
    public void apply(BattleContext context) {
        context.getPlayer().gainBlock(blockAmount);
    }
}
