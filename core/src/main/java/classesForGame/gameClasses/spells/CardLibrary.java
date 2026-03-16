package classesForGame.gameClasses.spells;

import classesForGame.enums.*;
import classesForGame.gameClasses.cardeffects.*;
import com.badlogic.gdx.utils.Array;

public class CardLibrary {

    public static Card firebolt() {
        Card card = new Card(
            "Firebolt",
            1,
            "Deal 5 damage.",
            Rarity.COMMON,
            CardType.ATTACK,
            TargetType.SINGLE_ENEMY,
            DamageType.FIRE
        );

        card.addEffect(new DamageEffect(5, DamageType.FIRE));
        return card;
    }

    public static Card fireball() {
        Card card = new Card(
            "Fireball",
            2,
            "Deal 12 damage.",
            Rarity.UNCOMMON,
            CardType.ATTACK,
            TargetType.SINGLE_ENEMY,
            DamageType.FIRE
        );

        card.addEffect(new DamageEffect(12, DamageType.FIRE));
        return card;
    }

    public static Card frostbite() {
        Card card = new Card(
            "Frostbite",
            1,
            "Deal 4 damage and apply 2 Frost.",
            Rarity.COMMON,
            CardType.ATTACK,
            TargetType.SINGLE_ENEMY,
            DamageType.ICE
        );

        card.addEffect(new DamageEffect(4, DamageType.ICE));
        card.addEffect(new ApplyStatusEffect(StatusEffectType.FROST, 2));
        return card;
    }

    public static Card thunderwave() {
        Card card = new Card(
            "Thunderwave",
            2,
            "Deal 7 damage to all enemies.",
            Rarity.UNCOMMON,
            CardType.ATTACK,
            TargetType.ALL_ENEMIES,
            DamageType.LIGHTNING
        );

        card.addEffect(new AoEDamageEffect(7, DamageType.LIGHTNING));
        return card;
    }

    public static Card meteor() {

        Card card = new Card(
            "Meteor",
            20,
            "A meteor falls from the sky, destroying all enemies.",
            Rarity.LEGENDARY,
            CardType.ATTACK,
            TargetType.ALL_ENEMIES,
            DamageType.FIRE
        );

        card.addEffect(new AoEDamageEffect(500, DamageType.FIRE));

        return card;
    }

    public static Card blizzard() {
        Card card = new Card(
            "Blizzard",
            4,
            "Deal 6 damage to all enemies and apply 2 Frost.",
            Rarity.RARE,
            CardType.ATTACK,
            TargetType.ALL_ENEMIES,
            DamageType.ICE
        );

        card.addEffect(new AoEDamageEffect(6, DamageType.ICE));
        card.addEffect(new AoEStatusEffect(StatusEffectType.FROST, 2));
        return card;
    }

    public static Card flameBurst() {
        Card card = new Card(
            "Flame Burst",
            1,
            "Deal 7 fire damage.",
            Rarity.COMMON,
            CardType.ATTACK,
            TargetType.SINGLE_ENEMY,
            DamageType.FIRE
        );

        card.addEffect(new DamageEffect(7, DamageType.FIRE));
        return card;
    }

    public static Card ignite() {
        Card card = new Card(
            "Ignite",
            2,
            "Deal 5 damage and apply 3 Burn.",
            Rarity.UNCOMMON,
            CardType.ATTACK,
            TargetType.SINGLE_ENEMY,
            DamageType.FIRE
        );

        card.addEffect(new DamageEffect(5, DamageType.FIRE));
        card.addEffect(new ApplyStatusEffect(StatusEffectType.BURN,3));
        return card;
    }

    public static Card fireShield() {
        Card card = new Card(
            "Fire Shield",
            2,
            "Gain 12 Block.",
            Rarity.COMMON,
            CardType.SKILL,
            TargetType.SELF,
            DamageType.FIRE
        );

        card.addEffect(new BlockEffect(12));
        return card;
    }

    public static Card iceLance() {
        Card card = new Card(
            "Ice Lance",
            1,
            "Deal 6 ice damage.",
            Rarity.COMMON,
            CardType.ATTACK,
            TargetType.SINGLE_ENEMY,
            DamageType.ICE
        );

        card.addEffect(new DamageEffect(6, DamageType.ICE));
        return card;
    }

    public static Card frostArmor() {
        Card card = new Card(
            "Frost Armor",
            2,
            "Gain 15 Block.",
            Rarity.UNCOMMON,
            CardType.SKILL,
            TargetType.SELF,
            DamageType.ICE
        );

        card.addEffect(new BlockEffect(15));
        return card;
    }

    public static Card freezingWave() {
        Card card = new Card(
            "Freezing Wave",
            4,
            "Deal 10 ice damage to all enemies.",
            Rarity.UNCOMMON,
            CardType.ATTACK,
            TargetType.ALL_ENEMIES,
            DamageType.ICE
        );

        card.addEffect(new AoEDamageEffect(10, DamageType.ICE));
        return card;
    }

    public static Card absoluteZero() {
        Card card = new Card(
            "Absolute Zero",
            3,
            "Apply 4 Frost.",
            Rarity.RARE,
            CardType.SKILL,
            TargetType.SINGLE_ENEMY,
            DamageType.ICE
        );

        card.addEffect(new ApplyStatusEffect(StatusEffectType.FROST,4));
        return card;
    }

    public static Card spark() {
        Card card = new Card(
            "Spark",
            1,
            "Deal 5 lightning damage.",
            Rarity.COMMON,
            CardType.ATTACK,
            TargetType.SINGLE_ENEMY,
            DamageType.LIGHTNING
        );

        card.addEffect(new DamageEffect(5, DamageType.LIGHTNING));
        return card;
    }

    public static Card chainLightning() {
        Card card = new Card(
            "Chain Lightning",
            3,
            "Deal 9 lightning damage to all enemies.",
            Rarity.UNCOMMON,
            CardType.ATTACK,
            TargetType.ALL_ENEMIES,
            DamageType.LIGHTNING
        );

        card.addEffect(new AoEDamageEffect(9, DamageType.LIGHTNING));
        return card;
    }

    public static Card thunderStrike() {
        Card card = new Card(
            "Thunder Strike",
            3,
            "Deal 18 lightning damage.",
            Rarity.UNCOMMON,
            CardType.ATTACK,
            TargetType.SINGLE_ENEMY,
            DamageType.LIGHTNING
        );

        card.addEffect(new DamageEffect(18, DamageType.LIGHTNING));
        return card;
    }

    public static Card staticBarrier() {
        Card card = new Card(
            "Static Barrier",
            2,
            "Gain 10 Block.",
            Rarity.COMMON,
            CardType.SKILL,
            TargetType.SELF,
            DamageType.LIGHTNING
        );

        card.addEffect(new BlockEffect(10));
        return card;
    }

    public static Card venomDart() {
        Card card = new Card(
            "Venom Dart",
            1,
            "Apply 4 Poison.",
            Rarity.COMMON,
            CardType.SKILL,
            TargetType.SINGLE_ENEMY,
            DamageType.POISON
        );

        card.addEffect(new ApplyStatusEffect(StatusEffectType.POISON,4));
        return card;
    }

    public static Card toxicStrike() {
        Card card = new Card(
            "Toxic Strike",
            2,
            "Deal 8 damage and apply 3 Poison.",
            Rarity.UNCOMMON,
            CardType.ATTACK,
            TargetType.SINGLE_ENEMY,
            DamageType.POISON
        );

        card.addEffect(new DamageEffect(8, DamageType.POISON));
        card.addEffect(new ApplyStatusEffect(StatusEffectType.POISON,3));
        return card;
    }

    public static Card poisonCloud() {
        Card card = new Card(
            "Poison Cloud",
            4,
            "Apply 5 Poison to all enemies.",
            Rarity.RARE,
            CardType.SKILL,
            TargetType.ALL_ENEMIES,
            DamageType.POISON
        );

        card.addEffect(new AoEStatusEffect(StatusEffectType.POISON, 2));
        return card;
    }

    public static Card shadowBolt() {
        Card card = new Card(
            "Shadow Bolt",
            2,
            "Deal 13 dark damage.",
            Rarity.COMMON,
            CardType.ATTACK,
            TargetType.SINGLE_ENEMY,
            DamageType.DARK
        );

        card.addEffect(new DamageEffect(13, DamageType.DARK));
        return card;
    }

    public static Card darkPulse() {
        Card card = new Card(
            "Dark Pulse",
            4,
            "Deal 12 dark damage to all enemies.",
            Rarity.UNCOMMON,
            CardType.ATTACK,
            TargetType.ALL_ENEMIES,
            DamageType.DARK
        );

        card.addEffect(new AoEDamageEffect(12, DamageType.DARK));
        return card;
    }

    public static Card curse() {
        Card card = new Card(
            "Curse",
            2,
            "Apply 3 Weak.",
            Rarity.UNCOMMON,
            CardType.SKILL,
            TargetType.SINGLE_ENEMY,
            DamageType.DARK
        );

        card.addEffect(new ApplyStatusEffect(StatusEffectType.WEAK,3));
        return card;
    }

    public static Card abyssalShield() {
        Card card = new Card(
            "Abyssal Shield",
            3,
            "Gain 20 Block.",
            Rarity.RARE,
            CardType.SKILL,
            TargetType.SELF,
            DamageType.DARK
        );

        card.addEffect(new BlockEffect(20));
        return card;
    }

    public static Card smite() {
        Card card = new Card(
            "Smite",
            2,
            "Deal 14 holy damage.",
            Rarity.COMMON,
            CardType.ATTACK,
            TargetType.SINGLE_ENEMY,
            DamageType.HOLY
        );

        card.addEffect(new DamageEffect(14, DamageType.HOLY));
        return card;
    }

    public static Card blessing() {
        Card card = new Card(
            "Blessing",
            2,
            "Gain 18 Block.",
            Rarity.UNCOMMON,
            CardType.SKILL,
            TargetType.SELF,
            DamageType.HOLY
        );

        card.addEffect(new BlockEffect(18));
        return card;
    }

    public static Card divineLight() {
        Card card = new Card(
            "Divine Light",
            5,
            "Deal 16 holy damage to all enemies.",
            Rarity.RARE,
            CardType.ATTACK,
            TargetType.ALL_ENEMIES,
            DamageType.HOLY
        );

        card.addEffect(new AoEDamageEffect(16, DamageType.HOLY));
        return card;
    }

    public static Card sanctuary() {
        Card card = new Card(
            "Sanctuary",
            5,
            "Gain 40 Block.",
            Rarity.RARE,
            CardType.SKILL,
            TargetType.SELF,
            DamageType.HOLY
        );

        card.addEffect(new BlockEffect(40));
        return card;
    }

    public static Card arcaneInsight() {
        Card card = new Card(
            "Arcane Insight",
            1,
            "Draw 2 cards.",
            Rarity.COMMON,
            CardType.SKILL,
            TargetType.SELF,
            DamageType.ARCANE
        );

        card.addEffect(new DrawCardEffect(2));
        return card;
    }

    public static Card manaSurge() {
        Card card = new Card(
            "Mana Surge",
            1,
            "Gain 2 mana.",
            Rarity.UNCOMMON,
            CardType.SKILL,
            TargetType.SELF,
            DamageType.ARCANE
        );

        card.addEffect(new GainManaEffect(2));
        return card;
    }

    public static Card holyFocus() {
        Card card = new Card(
            "Holy Focus",
            2,
            "Gain 2 Holy Charge.",
            Rarity.UNCOMMON,
            CardType.SKILL,
            TargetType.SELF,
            DamageType.HOLY
        );

        card.addEffect(new ApplyStatusToSelfEffect(StatusEffectType.HOLY_CHARGE, 2));
        return card;
    }

    public static Card bloodPact() {
        Card card = new Card(
            "Blood Pact",
            0,
            "Lose 6 HP. Gain 3 mana.",
            Rarity.RARE,
            CardType.SKILL,
            TargetType.SELF,
            DamageType.DARK
        );

        card.addEffect(new LoseLifeEffect(6));
        card.addEffect(new GainManaEffect(3));

        return card;
    }

    public static Card bloodSpark() {
        Card card = new Card(
            "Blood Spark",
            0,
            "Lose 3 HP. Deal 10 dark damage.",
            Rarity.COMMON,
            CardType.ATTACK,
            TargetType.SINGLE_ENEMY,
            DamageType.DARK
        );

        card.addEffect(new LoseLifeEffect(3));
        card.addEffect(new DamageEffect(10, DamageType.DARK));

        return card;
    }

    public static Card crimsonDraw() {
        Card card = new Card(
            "Crimson Draw",
            0,
            "Lose 4 HP. Draw 2 cards.",
            Rarity.COMMON,
            CardType.SKILL,
            TargetType.SELF,
            DamageType.DARK
        );

        card.addEffect(new LoseLifeEffect(4));
        card.addEffect(new DrawCardEffect(2));

        return card;
    }

    public static Card bloodExplosion() {
        Card card = new Card(
            "Blood Explosion",
            1,
            "Lose 10 HP. Deal 20 dark damage to all enemies.",
            Rarity.RARE,
            CardType.ATTACK,
            TargetType.ALL_ENEMIES,
            DamageType.DARK
        );

        card.addEffect(new LoseLifeEffect(10));
        card.addEffect(new AoEDamageEffect(20, DamageType.DARK));

        return card;
    }

    public static Card sacrifice() {
        Card card = new Card(
            "Sacrifice",
            0,
            "Lose 7 HP. Gain 2 mana and draw 2 cards.",
            Rarity.RARE,
            CardType.SKILL,
            TargetType.SELF,
            DamageType.DARK
        );

        card.addEffect(new LoseLifeEffect(7));
        card.addEffect(new GainManaEffect(2));
        card.addEffect(new DrawCardEffect(2));

        return card;
    }

    public static Card hemorrhage() {
        Card card = new Card(
            "Hemorrhage",
            1,
            "Lose 4 HP. Deal 12 damage and apply 3 Poison.",
            Rarity.UNCOMMON,
            CardType.ATTACK,
            TargetType.SINGLE_ENEMY,
            DamageType.DARK
        );

        card.addEffect(new LoseLifeEffect(4));
        card.addEffect(new DamageEffect(12, DamageType.DARK));
        card.addEffect(new ApplyStatusEffect(StatusEffectType.POISON, 3));

        return card;
    }

    public static Card lastOffering() {
        Card card = new Card(
            "Last Offering",
            0,
            "Set your HP to 1. Gain 15 mana.",
            Rarity.LEGENDARY,
            CardType.SKILL,
            TargetType.SELF,
            DamageType.DARK
        );

        card.addEffect(new SetHealthEffect(1));
        card.addEffect(new GainManaEffect(15));

        return card;
    }

    public static Card bloodSacrifice() {
        Card card = new Card(
            "Blood Sacrifice",
            2,
            "Lose half your HP. Deal triple that as dark damage.",
            Rarity.RARE,
            CardType.ATTACK,
            TargetType.SINGLE_ENEMY,
            DamageType.DARK
        );

        card.addEffect(new HalfLifeSacrificeEffect());

        return card;
    }

    public static Card divineJudgment() {
        Card card = new Card(
            "Divine Judgment",
            6,
            "Deal 40 holy damage.",
            Rarity.RARE,
            CardType.ATTACK,
            TargetType.SINGLE_ENEMY,
            DamageType.HOLY
        );

        card.addEffect(new DamageEffect(40, DamageType.HOLY));
        return card;
    }

    public static Card divineIntervention() {
        Card card = new Card(
            "Divine Intervention",
            10,
            "Restore 50 HP, gain 100 Block, and deal 50 holy damage to all enemies.",
            Rarity.LEGENDARY,
            CardType.SKILL,
            TargetType.SELF,
            DamageType.HOLY
        );

        card.addEffect(new HealEffect(50));
        card.addEffect(new BlockEffect(100));
        card.addEffect(new AoEDamageEffect(50, DamageType.HOLY));

        return card;
    }

    public static Card plaguebringer() {
        Card card = new Card(
            "Plaguebringer",
            10,
            "Apply 20 Poison, Weak, and Vulnerability to all enemies.",
            Rarity.LEGENDARY,
            CardType.SKILL,
            TargetType.ALL_ENEMIES,
            DamageType.POISON
        );

        card.addEffect(new AoEStatusEffect(StatusEffectType.POISON, 20));
        card.addEffect(new AoEStatusEffect(StatusEffectType.WEAK, 20));
        card.addEffect(new AoEStatusEffect(StatusEffectType.VULNERABLE, 20));

        return card;
    }

    public static Card stormOfHeaven() {
        Card card = new Card(
            "Storm of Heaven",
            10,
            "Deal 60 lightning damage to all enemies.",
            Rarity.LEGENDARY,
            CardType.ATTACK,
            TargetType.ALL_ENEMIES,
            DamageType.LIGHTNING
        );

        card.addEffect(new AoEDamageEffect(60, DamageType.LIGHTNING));

        return card;
    }

    public static Card iceAge() {
        Card card = new Card(
            "Absolute Winter",
            10,
            "Deal 40 ice damage to all enemies and apply 10 Frost to all enemies.",
            Rarity.LEGENDARY,
            CardType.ATTACK,
            TargetType.ALL_ENEMIES,
            DamageType.ICE
        );

        card.addEffect(new AoEDamageEffect(40, DamageType.ICE));
        card.addEffect(new AoEStatusEffect(StatusEffectType.FROST, 10));

        return card;
    }

    public static Card magicMissile() {
        Card card = new Card(
            "Magic Missile",
            -1,
            "Spend all mana. Fire X+2 missiles dealing 3 arcane damage each.",
            Rarity.COMMON,
            CardType.ATTACK,
            TargetType.SINGLE_ENEMY,
            DamageType.ARCANE
        );

        card.addEffect(new XEffect(new DamageEffect(3, DamageType.ARCANE),2));

        return card;
    }

    public static Card forbiddenKnowledge() {
        Card card = new Card(
            "Forbidden Knowledge",
            -1,
            "Spend all mana. Draw 1 card per mana spent.",
            Rarity.RARE,
            CardType.SKILL,
            TargetType.SELF,
            DamageType.DARK
        );

        card.addEffect(new XEffect(new DrawCardEffect(1), 0));

        return card;
    }

    public static Card timeStop() {
        Card card = new Card(
            "Time Stop",
            10,
            "Stop time. Skip the enemy turn, draw 3 cards, and gain 3 mana.",
            Rarity.LEGENDARY,
            CardType.SKILL,
            TargetType.SELF,
            DamageType.ARCANE
        );

        card.addEffect(new TimeStopEffect());

        return card;
    }

    public static Card genesis() {
        Card card = new Card(
            "Genesis",
            10,
            "Restore full HP, gain 999 Block, gain 10 mana, draw 10 cards, skip the enemy turn, and destroy all enemies.",
            Rarity.MYTHIC,
            CardType.SKILL,
            TargetType.ALL_ENEMIES,
            DamageType.ARCANE
        );

        card.addEffect(new HealEffect(9999));
        card.addEffect(new BlockEffect(999));
        card.addEffect(new GainManaEffect(10));
        card.addEffect(new DrawCardEffect(10));
        card.addEffect(new TimeStopEffect());
        card.addEffect(new AoEDamageEffect(9999, DamageType.ARCANE));

        return card;
    }

    public static Card shield() {
        Card card = new Card(
            "Shield",
            2,
            "Gain 18 Block.",
            Rarity.COMMON,
            CardType.SKILL,
            TargetType.SELF,
            DamageType.ARCANE
        );

        card.addEffect(new BlockEffect(18));

        return card;
    }

    public static Card arcaneBlast() {
        Card card = new Card(
            "Arcane Blast",
            3,
            "Deal 20 arcane damage.",
            Rarity.UNCOMMON,
            CardType.ATTACK,
            TargetType.SINGLE_ENEMY,
            DamageType.ARCANE
        );

        card.addEffect(new DamageEffect(20, DamageType.ARCANE));

        return card;
    }

    public static Card arcaneStorm() {
        Card card = new Card(
            "Arcane Storm",
            5,
            "Deal 14 arcane damage to all enemies.",
            Rarity.RARE,
            CardType.ATTACK,
            TargetType.ALL_ENEMIES,
            DamageType.ARCANE
        );

        card.addEffect(new AoEDamageEffect(14, DamageType.ARCANE));

        return card;
    }

    private static final Array<CardFactory> ALL_CARDS = new Array<>();

    static {
        ALL_CARDS.add(CardLibrary::firebolt);
        ALL_CARDS.add(CardLibrary::fireball);
        ALL_CARDS.add(CardLibrary::meteor);
        ALL_CARDS.add(CardLibrary::flameBurst);
        ALL_CARDS.add(CardLibrary::ignite);
        ALL_CARDS.add(CardLibrary::fireShield);

        ALL_CARDS.add(CardLibrary::iceLance);
        ALL_CARDS.add(CardLibrary::frostArmor);
        ALL_CARDS.add(CardLibrary::freezingWave);
        ALL_CARDS.add(CardLibrary::absoluteZero);
        ALL_CARDS.add(CardLibrary::blizzard);
        ALL_CARDS.add(CardLibrary::frostbite);
        ALL_CARDS.add(CardLibrary::iceAge);

        ALL_CARDS.add(CardLibrary::spark);
        ALL_CARDS.add(CardLibrary::chainLightning);
        ALL_CARDS.add(CardLibrary::thunderStrike);
        ALL_CARDS.add(CardLibrary::staticBarrier);
        ALL_CARDS.add(CardLibrary::thunderwave);
        ALL_CARDS.add(CardLibrary::stormOfHeaven);

        ALL_CARDS.add(CardLibrary::venomDart);
        ALL_CARDS.add(CardLibrary::toxicStrike);
        ALL_CARDS.add(CardLibrary::poisonCloud);
        ALL_CARDS.add(CardLibrary::plaguebringer);

        ALL_CARDS.add(CardLibrary::shadowBolt);
        ALL_CARDS.add(CardLibrary::curse);
        ALL_CARDS.add(CardLibrary::darkPulse);
        ALL_CARDS.add(CardLibrary::abyssalShield);
        ALL_CARDS.add(CardLibrary::bloodSpark);
        ALL_CARDS.add(CardLibrary::crimsonDraw);
        ALL_CARDS.add(CardLibrary::bloodExplosion);
        ALL_CARDS.add(CardLibrary::sacrifice);
        ALL_CARDS.add(CardLibrary::bloodPact);
        ALL_CARDS.add(CardLibrary::hemorrhage);
        ALL_CARDS.add(CardLibrary::lastOffering);
        ALL_CARDS.add(CardLibrary::bloodSacrifice);
        ALL_CARDS.add(CardLibrary::forbiddenKnowledge);

        ALL_CARDS.add(CardLibrary::smite);
        ALL_CARDS.add(CardLibrary::blessing);
        ALL_CARDS.add(CardLibrary::divineLight);
        ALL_CARDS.add(CardLibrary::sanctuary);
        ALL_CARDS.add(CardLibrary::holyFocus);
        ALL_CARDS.add(CardLibrary::divineJudgment);
        ALL_CARDS.add(CardLibrary::divineIntervention);

        ALL_CARDS.add(CardLibrary::arcaneInsight);
        ALL_CARDS.add(CardLibrary::manaSurge);
        ALL_CARDS.add(CardLibrary::magicMissile);
        ALL_CARDS.add(CardLibrary::timeStop);
        ALL_CARDS.add(CardLibrary::shield);
        ALL_CARDS.add(CardLibrary::arcaneBlast);
        ALL_CARDS.add(CardLibrary::arcaneStorm);

        ALL_CARDS.add(CardLibrary::genesis);
    }

    public static Array<Card> getCardsByRarity(Rarity rarity) {
        Array<Card> result = new Array<>();

        for (CardFactory factory : ALL_CARDS) {
            Card card = factory.create();

            if (card.getRarity() == rarity) {
                result.add(card);
            }
        }

        return result;
    }


    public static Array<Card> createStartingDeck() {
        Array<Card> deck = new Array<>();

        Array<Card> commons = getCardsByRarity(Rarity.COMMON);
        Array<Card> uncommons = getCardsByRarity(Rarity.UNCOMMON);
        Array<Card> rares = getCardsByRarity(Rarity.RARE);

        deck.addAll(commons);

        uncommons.shuffle();
        rares.shuffle();

        for (int i = 0; i < 3 && i < uncommons.size; i++) {
            deck.add(uncommons.get(i));
        }

        if (rares.size > 0) {
            deck.add(rares.first());
        }

        deck.shuffle();
        return deck;
    }


    public static boolean hasAllLegendaryCards(Array<Card> cards) {
        Array<Card> legendaryCards = getCardsByRarity(Rarity.LEGENDARY);

        for (Card legendary : legendaryCards) {
            boolean found = false;

            for (Card owned : cards) {
                if (owned.getName().equals(legendary.getName())) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }

    public static boolean canUnlockMythic(Array<Card> cards) {
        return hasAllLegendaryCards(cards);
    }

    public static Card getMythicCardIfUnlocked(Array<Card> cards) {
        if (canUnlockMythic(cards)) {
            return genesis();
        }

        return null;
    }
}
