package classesForGame.gameClasses.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;

import io.github.RogueLike1.Main;

public class MainMenuScreen extends BaseScreen {

    private Rectangle startButton;
    private Rectangle quitButton;

    public MainMenuScreen(Main game) {
        super(game);
    }

    @Override
    public void show() {
        startButton = new Rectangle(540, 380, 200, 60);
        quitButton = new Rectangle(540, 280, 200, 60);
    }

    @Override
    protected void update(float delta) {
        if (Gdx.input.justTouched()) {
            float mouseX = Gdx.input.getX();
            float mouseY = Gdx.input.getY();

            com.badlogic.gdx.math.Vector3 touchPos = new com.badlogic.gdx.math.Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            viewport.unproject(touchPos);

            float worldX = touchPos.x;
            float worldY = touchPos.y;

            if (startButton.contains(worldX, worldY)) {
                game.setScreen(new BattleScreen(game));
            }

            if (quitButton.contains(worldX, worldY)) {
                Gdx.app.exit();
            }
        }
    }

    @Override
    protected void draw(float delta) {
        Gdx.gl.glClearColor(0.08f, 0.08f, 0.12f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        game.getFont().draw(game.getBatch(), "Roguelike Card Game", 520, 560);
        game.getFont().draw(game.getBatch(), "[ Start Game ]", 585, 420);
        game.getFont().draw(game.getBatch(), "[ Quit ]", 610, 320);
        game.getBatch().end();
    }
}
