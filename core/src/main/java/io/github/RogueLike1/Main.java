package io.github.RogueLike1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import classesForGame.gameClasses.screens.MainMenuScreen;

public class Main extends Game {

    private SpriteBatch batch;
    private BitmapFont font;
    private AssetManager assetManager;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        assetManager = new AssetManager();

        setScreen(new MainMenuScreen(this));
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public BitmapFont getFont() {
        return font;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        if (screen != null) {
            screen.dispose();
        }
        batch.dispose();
        font.dispose();
        assetManager.dispose();
    }
}
