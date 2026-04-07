package io.github.some_example_name;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;


public class Bullet {

    private TextureRegion bullet;
    private Circle circle;
    private float radius = 0.2f;
    private float speed=6f;
    Vector2 direction;


    public Bullet(Assets assets, float x, float y,Vector2 direction) {
        this.bullet = assets.getBullet3();
        this.circle = new Circle(x,y, radius);
        this.direction = new Vector2(direction).nor(); //copy

    }

    public void update( float delta){
        circle.x += direction.x * delta * speed;
        circle.y += direction.y * delta * speed;

    }

    public void draw(SpriteBatch batch){
        float rotation = direction.angleDeg() - 90f; // if tip points left

        batch.draw(
            bullet,
            circle.x - radius,
            circle.y - radius,
            radius,        // originX
            radius,        // originY
            2 * radius,    // width
            2 * radius,    // height
            1f,            // scaleX
            1f,            // scaleY
            rotation       // rotation in degrees
        );
    }
    }

