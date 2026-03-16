package classesForGame.gameClasses.relics;

import classesForGame.entities.Player;
import classesForGame.enums.RelicRarity;
import classesForGame.gameClasses.BattleContext;
import classesForGame.gameClasses.spells.Card;

public abstract class Relic {

    private String name;
    private String description;
    private RelicRarity rarity;

    public Relic(String name, String description, RelicRarity rarity) {
        this.name = name;
        this.description = description;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public RelicRarity getRarity() {
        return rarity;
    }

    public void onBattleStart(Player player) {}

    public void onTurnStart(Player player) {}

    public void onTurnEnd(Player player) {}

    public void onCardPlayed(Player player, Card card, BattleContext context) {}

    public void onEnemyKilled(Player player) {}

    public void onDamageTaken(Player player, int amount) {}
}
