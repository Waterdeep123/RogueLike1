package classesForGame.gameClasses.spells;

import com.badlogic.gdx.utils.Array;

import classesForGame.enums.CardType;
import classesForGame.enums.Rarity;
import classesForGame.enums.TargetType;
import classesForGame.gameClasses.BattleContext;
import classesForGame.gameClasses.CardEffect;
import classesForGame.enums.DamageType;

public class Card {

    private String name;
    private int cost;
    private String description;
    private Rarity rarity;
    private CardType type;
    private TargetType targetType;
    private Array<CardEffect> effects;
    private DamageType damageType;

    public Card(String name, int cost, String description,
                Rarity rarity, CardType type, TargetType targetType, DamageType damageType) {

        this.name = name;
        this.cost = cost;
        this.description = description;
        this.rarity = rarity;
        this.type = type;
        this.targetType = targetType;
        this.damageType = damageType;
        this.effects = new Array<>();
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void addEffect(CardEffect effect) {
        effects.add(effect);
    }

    public void play(BattleContext context) {
        for (CardEffect effect : effects) {
            effect.apply(context);
        }
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public CardType getType() {
        return type;
    }

    public TargetType getTargetType() {
        return targetType;
    }
}
