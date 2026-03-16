package classesForGame.gameClasses.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import io.github.RogueLike1.Main;

import classesForGame.gameClasses.spells.Card;
import classesForGame.gameClasses.spells.CardLibrary;
import classesForGame.entities.Enemy;
import classesForGame.entities.Player;
import classesForGame.enums.PileType;
import classesForGame.gameClasses.BattleContext;
import classesForGame.gameClasses.Deck;

public class BattleScreen extends BaseScreen {

    private Player player;
    private Array<Enemy> enemies;

    private Array<Rectangle> cardBounds;
    private Rectangle endTurnButton;
    private BattleContext battleContext;

    public BattleScreen(Main game) {
        super(game);
    }

    @Override
    public void show() {
        player = new Player("Mage", 50);

        enemies = new Array<>();
        enemies.add(new Enemy("Goblin", 30));
        enemies.add(new Enemy("Slime", 20));
        enemies.add(new Enemy("Imp", 15));

        Deck startingDeck = new Deck(CardLibrary.createStartingDeck(), true);
        player.setDeck(startingDeck);
        player.startCombat();

        cardBounds = new Array<>();
        endTurnButton = new Rectangle(1050, 60, 160, 60);

        layoutCards();
    }

    private void layoutCards() {
        cardBounds.clear();

        Array<Card> hand = player.getDeck().getPile(PileType.HAND);

        float startX = 120;
        float y = 80;
        float width = 150;
        float height = 220;
        float spacing = 25;

        for (int i = 0; i < hand.size; i++) {
            float x = startX + i * (width + spacing);
            cardBounds.add(new Rectangle(x, y, width, height));
        }
    }

    @Override
    protected void update(float delta) {
        handleInput();
    }

    private void handleInput() {
        if (!Gdx.input.justTouched()) {
            return;
        }

        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        viewport.unproject(touchPos);

        float x = touchPos.x;
        float y = touchPos.y;

        if (endTurnButton.contains(x, y)) {
            endPlayerTurn();
            return;
        }

        for (int i = 0; i < cardBounds.size; i++) {
            if (cardBounds.get(i).contains(x, y)) {
                playCard(i);
                return;
            }
        }
    }


    private void playCard(int index) {
        Array<Card> hand = player.getDeck().getPile(PileType.HAND);

        if (index < 0 || index >= hand.size) {
            return;
        }

        Card card = hand.get(index);

        Enemy target = getFirstLivingEnemy();
        if (target == null) {
            return;
        }

        int cost = card.getCost();

        // Handle normal-cost cards
        if (cost >= 0) {
            if (!player.canPlayCard(cost)) {
                return;
            }

            if (!player.spendMana(cost)) {
                return;
            }
        }
        // Handle X-cost cards
        else if (cost == -1) {
            if (player.getMana() <= 0) {
                return;
            }
        }

        battleContext = new BattleContext(
            player,
            target,
            enemies,
            player.getDeck()
        );

        card.play(battleContext);

        player.getDeck().removeFromHand(card);
        player.getDeck().addToDiscard(card);

        removeDeadEnemies();
        layoutCards();

        if (enemies.size == 0) {
            System.out.println("Victory!");
        }
    }

    private Enemy getFirstLivingEnemy() {
        for (Enemy enemy : enemies) {
            if (!enemy.isDead()) {
                return enemy;
            }
        }
        return null;
    }

    private void removeDeadEnemies() {
        for (int i = enemies.size - 1; i >= 0; i--) {
            if (enemies.get(i).isDead()) {
                enemies.removeIndex(i);
            }
        }
    }

    private void endPlayerTurn() {
        player.endTurn();
        enemyTurn();

        if (!player.isDead()) {
            player.startTurn();
            layoutCards();
        }
    }

    private void enemyTurn() {

        if (battleContext.isSkipEnemyTurn()) {
            battleContext.setSkipEnemyTurn(false);
            return;
        }

        for (Enemy enemy : enemies) {
            if (!enemy.isDead()) {
                player.takeDamage(4);
            }
        }

        if (player.isDead()) {
            System.out.println("Defeat!");
        }
    }

    @Override
    protected void draw(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.08f, 0.12f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();

        drawPlayer();
        drawEnemies();
        drawDeckInfo();
        drawCards();
        drawEndTurnButton();

        game.getBatch().end();
    }

    private void drawPlayer() {
        game.getFont().draw(game.getBatch(), "Player: " + player.getName(), 40, 680);
        game.getFont().draw(game.getBatch(), "HP: " + player.getHealth() + "/" + player.getMaxHealth(), 40, 650);
        game.getFont().draw(game.getBatch(), "Block: " + player.getBlock(), 40, 620);
        game.getFont().draw(game.getBatch(), "Mana: " + player.getMana() + "/" + player.getMaxMana(), 40, 590);
    }

    private void drawEnemies() {
        float y = 680;

        for (Enemy enemy : enemies) {
            game.getFont().draw(game.getBatch(), "Enemy: " + enemy.getName(), 500, y);
            game.getFont().draw(game.getBatch(), "HP: " + enemy.getHealth() + "/" + enemy.getMaxHealth(), 500, y - 30);
            game.getFont().draw(game.getBatch(), "Block: " + enemy.getBlock(), 500, y - 60);
            y -= 100;
        }
    }

    private void drawDeckInfo() {
        Deck deck = player.getDeck();

        game.getFont().draw(game.getBatch(), "Draw: " + deck.size(PileType.DRAW), 1000, 680);
        game.getFont().draw(game.getBatch(), "Discard: " + deck.size(PileType.DISCARD), 1000, 650);
        game.getFont().draw(game.getBatch(), "Exile: " + deck.size(PileType.EXILE), 1000, 620);
        game.getFont().draw(game.getBatch(), "Hand: " + deck.size(PileType.HAND), 1000, 590);
    }

    private void drawCards() {
        Array<Card> hand = player.getDeck().getPile(PileType.HAND);

        for (int i = 0; i < hand.size; i++) {
            Card card = hand.get(i);
            Rectangle bounds = cardBounds.get(i);

            float textX = bounds.x + 10;
            float topY = bounds.y + bounds.height - 10;

            game.getFont().draw(game.getBatch(), "-------------------", bounds.x, bounds.y + bounds.height);
            game.getFont().draw(game.getBatch(), card.getName(), textX, topY);
            String costText = card.getCost() == -1 ? "X" : String.valueOf(card.getCost());
            game.getFont().draw(game.getBatch(), "Cost: " + costText, textX, topY - 25);
            game.getFont().draw(game.getBatch(), card.getDescription(), textX, topY - 50);
            game.getFont().draw(game.getBatch(), card.getRarity().name(), textX, topY - 75);
            game.getFont().draw(game.getBatch(), "-------------------", bounds.x, bounds.y + 10);
        }
    }

    private void drawEndTurnButton() {
        game.getFont().draw(game.getBatch(), "[ End Turn ]", endTurnButton.x + 20, endTurnButton.y + 35);
    }

    @Override
    public void dispose() {
    }
}
