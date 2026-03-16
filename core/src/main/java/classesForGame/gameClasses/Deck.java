package classesForGame.gameClasses;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.math.MathUtils;

import classesForGame.gameClasses.spells.Card;
import classesForGame.enums.PileType;

/**
 * Deck manager with automatic "reshuffle discard into draw" behavior when draw
 * pile is empty and a draw is requested.
 */
public class Deck {

    private final Array<Card> drawPile = new Array<>();
    private final Array<Card> hand = new Array<>();
    private final Array<Card> discardPile = new Array<>();
    private final Array<Card> exilePile = new Array<>();

    public Deck() { }

    public Deck(Array<Card> startingCards, boolean shuffleOnCreate) {
        if (startingCards != null) {
            drawPile.addAll(startingCards);
            if (shuffleOnCreate) shuffleDrawPile();
        }
    }

    // ---------------- Pile helpers ---------------- //

    public Array<Card> getPile(PileType type) {
        switch (type) {
            case DRAW: return drawPile;
            case HAND: return hand;
            case DISCARD: return discardPile;
            case EXILE: return exilePile;
            default: return null;
        }
    }

    public void addCard(Card card, PileType pile) {
        if (card == null) return;
        getPile(pile).add(card);
    }

    public void moveCard(Card card, PileType from, PileType to) {
        if (card == null) return;
        Array<Card> fromPile = getPile(from);
        Array<Card> toPile = getPile(to);
        if (fromPile != null && toPile != null) {
            if (fromPile.removeValue(card, true)) {
                toPile.add(card);
            }
        }
    }

    // ---------------- Shuffling / Reshuffle ---------------- //

    /** Shuffle the draw pile in-place. */
    public void shuffleDrawPile() {
        drawPile.shuffle();
    }

    /** Manual reshuffle: move discard into draw and shuffle. */
    public void shuffleDiscardIntoDraw() {
        if (discardPile.size == 0) return;
        drawPile.addAll(discardPile);
        discardPile.clear();
        drawPile.shuffle();
    }

    /** Force a full reshuffle of all piles into draw (optionally preserve hand). */
    public void reshuffleAllIntoDraw(boolean keepHand) {
        Array<Card> all = new Array<>();
        all.addAll(drawPile);
        all.addAll(discardPile);
        if (!keepHand) {
            all.addAll(hand);
            hand.clear();
        }
        drawPile.clear();
        discardPile.clear();
        drawPile.addAll(all);
        drawPile.shuffle();
    }

    // ---------------- Drawing ---------------- //

    /**
     * Draw a single card. If draw pile is empty, automatically reshuffle the discard
     * pile into the draw pile (and shuffle) before attempting to draw. Returns null
     * if still nothing to draw.
     */
    public Card drawCard() {
        if (drawPile.size == 0) {
            shuffleDiscardIntoDraw();
        }

        if (drawPile.size == 0) {
            return null; // nothing to draw
        }

        Card c = drawPile.pop(); // top of draw pile
        hand.add(c);
        return c;
    }

    /** Draw up to `amount` cards and return the drawn cards (may be fewer if deck is small). */
    public Array<Card> drawCards(int amount) {
        Array<Card> drawn = new Array<>();
        for (int i = 0; i < amount; i++) {
            Card c = drawCard();
            if (c == null) break;
            drawn.add(c);
        }
        return drawn;
    }

    /** Draw a starting hand; optionally discard current hand first. */
    public Array<Card> drawStartingHand(int count, boolean discardCurrentHand) {
        if (discardCurrentHand) {
            discardHand();
        }
        return drawCards(count);
    }

    // ---------------- Hand / Discard / Exile ---------------- //

    public void discardFromHand(Card card) {
        if (card == null) return;
        if (hand.removeValue(card, true)) {
            discardPile.add(card);
        }
    }

    public void discardHand() {
        if (hand.size > 0) {
            discardPile.addAll(hand);
            hand.clear();
        }
    }

    /** Remove card from hand without discarding (useful for playing/exhausting). */
    public boolean removeFromHand(Card card) {
        return card != null && hand.removeValue(card, true);
    }

    public void exileCard(Card card) {
        if (card == null) return;
        // remove from any pile
        drawPile.removeValue(card, true);
        hand.removeValue(card, true);
        discardPile.removeValue(card, true);
        exilePile.add(card);
    }

    /** Add to top of draw pile (will be drawn next). */
    public void addToTopOfDraw(Card card) {
        if (card == null) return;
        drawPile.add(card);
    }

    /** Add to bottom of draw pile (will be drawn last). */
    public void addToBottomOfDraw(Card card) {
        if (card == null) return;
        drawPile.insert(0, card);
    }

    /** Add to discard pile. */
    public void addToDiscard(Card card) {
        if (card == null) return;
        discardPile.add(card);
    }

    // ---------------- Utilities / Introspection ---------------- //

    public Array<Card> getDrawPile() { return drawPile; }
    public Array<Card> getHand() { return hand; }
    public Array<Card> getDiscardPile() { return discardPile; }
    public Array<Card> getExilePile() { return exilePile; }

    public int size(PileType pile) {
        Array<Card> p = getPile(pile);
        return p == null ? 0 : p.size;
    }

    public Card peekTopDraw() {
        if (drawPile.size == 0) return null;
        return drawPile.peek();
    }

    /** Random shuffle using MathUtils (same as Array.shuffle but explicit implementation if needed). */
    public void rngShuffleDrawPile() {
        for (int i = drawPile.size - 1; i > 0; i--) {
            int j = MathUtils.random(i);
            Card tmp = drawPile.get(i);
            drawPile.set(i, drawPile.get(j));
            drawPile.set(j, tmp);
        }
    }
}
