package io.github.some_example_name;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;


public class Bullet {

    private TextureRegion bullet;
    private Circle circle;
    private Vector2 startingPosition;
    private float radius = 0.25f;

    public Bullet(Assets assets, Vector2 startingPosition) {
        this.bullet = assets.getBullet2();
        this.circle = new Circle(startingPosition, radius);

    }

    public void update(Vector2 direction){

    }

    public void draw(SpriteBatch batch){

    }
}
