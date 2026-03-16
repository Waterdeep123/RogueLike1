package classesForGame.gameClasses.relics;

import classesForGame.gameClasses.BattleContext;
import com.badlogic.gdx.utils.Array;

import classesForGame.gameClasses.spells.Card;
import classesForGame.entities.Player;
import classesForGame.enums.PileType;
import classesForGame.enums.RelicRarity;

public class RelicLibrary {

    private static final Array<Relic> ALL_RELICS = new Array<>();

    static {
        ALL_RELICS.add(manaCrystal());
        ALL_RELICS.add(ironCharm());
        ALL_RELICS.add(wisdomFeather());
        ALL_RELICS.add(vitalitySeed());
        ALL_RELICS.add(emberCharm());
        ALL_RELICS.add(frozenCore());
        ALL_RELICS.add(stormCharm());
        ALL_RELICS.add(venomVial());
        ALL_RELICS.add(shadowSigil());
        ALL_RELICS.add(sunAmulet());

        ALL_RELICS.add(bloodIdol());
        ALL_RELICS.add(phoenixAsh());
        ALL_RELICS.add(thunderDrum());
        ALL_RELICS.add(glacierHeart());
        ALL_RELICS.add(plagueMask());
        ALL_RELICS.add(nightCrown());
        ALL_RELICS.add(holyScripture());
        ALL_RELICS.add(arcaneLens());
        ALL_RELICS.add(reapersCoin());
        ALL_RELICS.add(sorcerersRing());

        ALL_RELICS.add(divineArtifact());
        ALL_RELICS.add(blackStar());
        ALL_RELICS.add(crownOfStorms());
        ALL_RELICS.add(eternalChalice());
        ALL_RELICS.add(worldrootShard());
    }

    public static Array<Relic> getRelicsByRarity(RelicRarity rarity) {
        Array<Relic> result = new Array<>();

        for (Relic relic : ALL_RELICS) {
            if (relic.getRarity() == rarity) {
                result.add(relic);
            }
        }

        return result;
    }

    public static Relic randomRelic(RelicRarity rarity) {
        Array<Relic> relics = getRelicsByRarity(rarity);
        if (relics.size == 0) {
            return null;
        }
        return relics.random();
    }

    // ---------------- COMMON ----------------

    public static Relic manaCrystal() {
        return new Relic(
            "Mana Crystal",
            "Start each battle with 1 extra mana.",
            RelicRarity.COMMON
        ) {
            @Override
            public void onBattleStart(Player player) {
                player.gainMana(1);
            }
        };
    }

    public static Relic ironCharm() {
        return new Relic(
            "Iron Charm",
            "Start each battle with 8 Block.",
            RelicRarity.COMMON
        ) {
            @Override
            public void onBattleStart(Player player) {
                player.gainBlock(8);
            }
        };
    }

    public static Relic wisdomFeather() {
        return new Relic(
            "Wisdom Feather",
            "Draw 1 extra card at the start of each turn.",
            RelicRarity.COMMON
        ) {
            @Override
            public void onTurnStart(Player player) {
                player.getDeck().drawCards(1);
            }
        };
    }

    public static Relic vitalitySeed() {
        return new Relic(
            "Vitality Seed",
            "At the start of each turn, heal 2 HP.",
            RelicRarity.COMMON
        ) {
            @Override
            public void onTurnStart(Player player) {
                player.heal(2);
            }
        };
    }

    public static Relic emberCharm() {
        return new Relic(
            "Ember Charm",
            "Whenever you play a FIRE card, gain 3 Block.",
            RelicRarity.COMMON
        ) {
            @Override
            public void onCardPlayed(Player player, Card card, BattleContext context) {
                if (card.getDamageType() != null && card.getDamageType().name().equals("FIRE")) {
                    player.gainBlock(3);
                }
            }
        };
    }

    public static Relic frozenCore() {
        return new Relic(
            "Frozen Core",
            "At the end of each turn, gain 5 Block.",
            RelicRarity.COMMON
        ) {
            @Override
            public void onTurnEnd(Player player) {
                player.gainBlock(5);
            }
        };
    }

    public static Relic stormCharm() {
        return new Relic(
            "Storm Charm",
            "Whenever you play a LIGHTNING card, gain 1 mana.",
            RelicRarity.COMMON
        ) {
            @Override
            public void onCardPlayed(Player player, Card card, BattleContext context) {
                if (card.getDamageType() != null && card.getDamageType().name().equals("LIGHTNING")) {
                    player.gainMana(1);
                }
            }
        };
    }

    public static Relic venomVial() {
        return new Relic(
            "Venom Vial",
            "At battle start, draw 1 extra card.",
            RelicRarity.COMMON
        ) {
            @Override
            public void onBattleStart(Player player) {
                player.getDeck().drawCards(1);
            }
        };
    }

    public static Relic shadowSigil() {
        return new Relic(
            "Shadow Sigil",
            "Whenever you lose life, gain 4 Block.",
            RelicRarity.COMMON
        ) {
            @Override
            public void onDamageTaken(Player player, int amount) {
                player.gainBlock(4);
            }
        };
    }

    public static Relic sunAmulet() {
        return new Relic(
            "Sun Amulet",
            "Whenever you play a HOLY card, heal 2 HP.",
            RelicRarity.COMMON
        ) {
            @Override
            public void onCardPlayed(Player player, Card card, BattleContext context) {
                if (card.getDamageType() != null && card.getDamageType().name().equals("HOLY")) {
                    player.heal(2);
                }
            }
        };
    }

    // ---------------- RARE ----------------

    public static Relic bloodIdol() {
        return new Relic(
            "Blood Idol",
            "Whenever you lose life, gain 2 mana.",
            RelicRarity.RARE
        ) {
            @Override
            public void onDamageTaken(Player player, int amount) {
                player.gainMana(2);
            }
        };
    }

    public static Relic phoenixAsh() {
        return new Relic(
            "Phoenix Ash",
            "At battle start, gain 20 Block and heal 10 HP.",
            RelicRarity.RARE
        ) {
            @Override
            public void onBattleStart(Player player) {
                player.gainBlock(20);
                player.heal(10);
            }
        };
    }

    public static Relic thunderDrum() {
        return new Relic(
            "Thunder Drum",
            "At the start of each turn, gain 1 mana.",
            RelicRarity.RARE
        ) {
            @Override
            public void onTurnStart(Player player) {
                player.gainMana(1);
            }
        };
    }

    public static Relic glacierHeart() {
        return new Relic(
            "Glacier Heart",
            "At the start of each turn, gain 10 Block.",
            RelicRarity.RARE
        ) {
            @Override
            public void onTurnStart(Player player) {
                player.gainBlock(10);
            }
        };
    }

    public static Relic plagueMask() {
        return new Relic(
            "Plague Mask",
            "Whenever you kill an enemy, draw 2 cards.",
            RelicRarity.RARE
        ) {
            @Override
            public void onEnemyKilled(Player player) {
                player.getDeck().drawCards(2);
            }
        };
    }

    public static Relic nightCrown() {
        return new Relic(
            "Night Crown",
            "At battle start, lose 5 HP and gain 3 mana.",
            RelicRarity.RARE
        ) {
            @Override
            public void onBattleStart(Player player) {
                player.takeDamage(5);
                player.gainMana(3);
            }
        };
    }

    public static Relic holyScripture() {
        return new Relic(
            "Holy Scripture",
            "At the end of each turn, heal 5 HP.",
            RelicRarity.RARE
        ) {
            @Override
            public void onTurnEnd(Player player) {
                player.heal(5);
            }
        };
    }

    public static Relic arcaneLens() {
        return new Relic(
            "Arcane Lens",
            "Whenever you play an X-cost card, draw 2 cards.",
            RelicRarity.RARE
        ) {
            @Override
            public void onCardPlayed(Player player, Card card, BattleContext context) {
                if (card.getCost() == -1) {
                    player.getDeck().drawCards(2);
                }
            }
        };
    }

    public static Relic reapersCoin() {
        return new Relic(
            "Reaper's Coin",
            "Whenever you kill an enemy, heal 6 HP.",
            RelicRarity.RARE
        ) {
            @Override
            public void onEnemyKilled(Player player) {
                player.heal(6);
            }
        };
    }

    public static Relic sorcerersRing() {
        return new Relic(
            "Sorcerer's Ring",
            "Start each battle with 2 extra cards in hand.",
            RelicRarity.RARE
        ) {
            @Override
            public void onBattleStart(Player player) {
                player.getDeck().drawCards(2);
            }
        };
    }

    // ---------------- ARTIFACT ----------------

    public static Relic divineArtifact() {
        return new Relic(
            "Divine Artifact",
            "Start each battle with 50 Block.",
            RelicRarity.ARTIFACT
        ) {
            @Override
            public void onBattleStart(Player player) {
                player.gainBlock(50);
            }
        };
    }

    public static Relic blackStar() {
        return new Relic(
            "Black Star",
            "At battle start, set mana to max and draw 3 cards.",
            RelicRarity.ARTIFACT
        ) {
            @Override
            public void onBattleStart(Player player) {
                player.gainMana(10);
                player.getDeck().drawCards(3);
            }
        };
    }

    public static Relic crownOfStorms() {
        return new Relic(
            "Crown of Storms",
            "At the start of each turn, gain 2 mana and draw 1 card.",
            RelicRarity.ARTIFACT
        ) {
            @Override
            public void onTurnStart(Player player) {
                player.gainMana(2);
                player.getDeck().drawCards(1);
            }
        };
    }

    public static Relic eternalChalice() {
        return new Relic(
            "Eternal Chalice",
            "At the end of each turn, heal 10 HP and gain 10 Block.",
            RelicRarity.ARTIFACT
        ) {
            @Override
            public void onTurnEnd(Player player) {
                player.heal(10);
                player.gainBlock(10);
            }
        };
    }

    public static Relic worldrootShard() {
        return new Relic(
            "Worldroot Shard",
            "At battle start, draw until you have 7 cards in hand.",
            RelicRarity.ARTIFACT
        ) {
            @Override
            public void onBattleStart(Player player) {
                int handSize = player.getDeck().size(PileType.HAND);
                int toDraw = 7 - handSize;

                if (toDraw > 0) {
                    player.getDeck().drawCards(toDraw);
                }
            }
        };
    }
}
