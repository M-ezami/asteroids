package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuScreen extends ScreenAdapter {
    GDXGAME game;
    SpriteBatch batch;
    BitmapFont font;
    Viewport viewport;
    GlyphLayout layout;

    public MenuScreen(GDXGAME game) {
        this.game = game;
        this.batch = game.getBatch();
        this.font = game.getFont();
        viewport = new ScreenViewport();
        layout = new GlyphLayout();
    }



    @Override
    public void resize(int width, int height) {
        viewport.update(width,height,true);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            game.setScreen(new GameScreen(game));
        }
        float x = viewport.getWorldWidth() / 2;
        float y = viewport.getWorldHeight() / 2 + 100;


        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        layout.setText(font,"Welcome to Asteroids");
        font.draw(batch,layout,x-layout.width/2,y);
        y-= 40f;
        layout.setText(font,"Level up and destroy as many asteroids as possible good luck!");
        font.draw(batch,layout,x-layout.width/2,y);
        y-= 40f;
        layout.setText(font,"Press SPACE to Start");
        font.draw(batch,layout,x-layout.width/2,y);
        batch.end();


    }





}
