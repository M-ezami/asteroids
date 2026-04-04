package io.github.some_example_name;


import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;
import java.util.List;

public class GameScreen extends ScreenAdapter {
    private GDXGAME game;
    private Viewport gamePort;
    private Asteroid asteroid;
    private Assets assets;
    private SpriteBatch batch;
    private List<Asteroid> asteroidList;
    private Level level;
    private Shooter shooter;

    public GameScreen(GDXGAME game) {
        this.game = game;
        this.gamePort = new StretchViewport(GDXGAME.WORLD_WIDTH, GDXGAME.WORLD_HEIGHT);
        this.assets = game.getAssets();
        this.batch = game.getBatch();
        level = Level.LEVEL1;
        this.asteroidList = new ArrayList<>();
        createAsteroids();
        shooter = new Shooter(assets);
    }




    private List<TextureRegion> getTexturesForSize(AsteroidSize size) {
        switch (size) {
            case SMALL:
                return assets.getAllSmallAsteroids();
            case MEDIUM:
                return assets.getAllMediumAsteroids();
            case BIG:
                return assets.getAllBigAsteroids();
            default:
                throw new IllegalArgumentException("Unknown size: " + size);
        }
    }

    private void spawnAsteroids(int amount, AsteroidSize size) {
        List<TextureRegion> textures = getTexturesForSize(size);

        for (int i = 0; i < amount; i++) {
            TextureRegion texture = textures.get(MathUtils.random(textures.size() - 1));
            asteroidList.add(new Asteroid(texture, size));
        }
    }


    public void createAsteroids() {
        spawnAsteroids(level.getSmallSize(), AsteroidSize.SMALL);
        spawnAsteroids(level.getMediumSize(), AsteroidSize.MEDIUM);
        spawnAsteroids(level.getBigSize(), AsteroidSize.BIG);

    }

    @Override
    public void resize(int width, int height) {
    gamePort.update(width,height,true);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        batch.setProjectionMatrix(gamePort.getCamera().combined);
        batch.begin();
        shooter.draw(batch);
        shooter.update(delta);
        for (Asteroid asteroid : asteroidList) {
            asteroid.update(delta);
            asteroid.draw(batch);
            if(shooter.collision(asteroid.getCircle())){
                game.setScreen(new MenuScreen(game));
            }
        }



        batch.end();
    }
}
