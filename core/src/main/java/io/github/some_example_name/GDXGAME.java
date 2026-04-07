package io.github.some_example_name;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
/**
 * ApplicationListener implementation shared by all platforms.
 */
public class GDXGAME extends Game {

    private SpriteBatch batch;
    private BitmapFont font;
    private Assets assets;

    @Override
    public void create() {
        batch = new SpriteBatch();
        assets = new Assets();
        assets.load();
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.color = Color.BLUE;
        parameter.size = 24;
        font = generator.generateFont(parameter);
        generator.dispose();
        setScreen(new MenuScreen(this));
    }



    @Override
    public void dispose() {
        super.dispose();
        if (batch != null) batch.dispose();
        if (font != null) font.dispose();
        if (assets != null) assets.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public BitmapFont getFont() {
        return font;
    }

    public Assets getAssets() {
        return assets;
    }


    public static final float WORLD_WIDTH = 16f;
    public static final float WORLD_HEIGHT = 9f;
}
