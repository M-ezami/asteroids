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
    private float speed=1.5f;

    public Bullet(Assets assets, float x, float y) {
        this.bullet = assets.getBullet2();
        this.circle = new Circle(x,y, radius);

    }

    public void update(Vector2 direction, float delta){
        circle.x+= direction.x*delta*speed;
        circle.y+= direction.y*delta*speed;
    }

    public void draw(SpriteBatch batch){
        batch.draw(bullet,circle.x-radius,circle.y-radius,2*radius,2*radius);
    }
}
