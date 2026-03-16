package classesForGame.gameClasses.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import io.github.RogueLike1.Main;

public abstract class BaseScreen implements Screen {

    protected final Main game;
    protected final OrthographicCamera camera;
    protected final Viewport viewport;

    protected static final float WORLD_WIDTH = 1280;
    protected static final float WORLD_HEIGHT = 720;

    public BaseScreen(Main game) {
        this.game = game;
        this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        this.viewport.apply();
        this.camera.position.set(WORLD_WIDTH / 2f, WORLD_HEIGHT / 2f, 0);
        this.camera.update();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        update(delta);
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);
        draw(delta);
    }

    protected abstract void update(float delta);

    protected abstract void draw(float delta);

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
}
