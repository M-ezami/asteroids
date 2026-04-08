package io.github.some_example_name;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {

    private final float minSpeed = 1f;
    private final float maxSpeed = 4f;

    private TextureRegion texture;
    private Circle circle;

    private float x;
    private float y;
    private float radius;
    private float drawRadius;
    private float speed;
    private Vector2 direction;
    private AsteroidSize size;

    public Asteroid(TextureRegion texture, AsteroidSize size) {
        this.texture = texture;
        this.size = size;
        this.radius = size.radius * 0.45f;
        this.drawRadius = size.radius;
        startingPosition();
        direction();
        this.circle = new Circle(x, y, radius);
        this.speed = MathUtils.random(minSpeed, maxSpeed);
    }

    public Asteroid(TextureRegion texture,float x, float y,AsteroidSize size) {
        this.texture = texture;
        this.size = size;
        this.radius = size.radius * 0.45f;
        this.drawRadius = size.radius;
        direction();
        this.circle = new Circle(x, y, radius);
        this.speed = MathUtils.random(minSpeed, maxSpeed);
    }

    public AsteroidSize getAsteroidSize() {
        return size;
    }



    public Circle getCircle() {
        return circle;
    }

    public void startingPosition() {
        boolean verticalEdge;
        verticalEdge = MathUtils.randomBoolean();
        if (verticalEdge) {
            x = MathUtils.random(0.2f, GDXGAME.WORLD_WIDTH);
            y = MathUtils.randomBoolean() ? 0f : GDXGAME.WORLD_HEIGHT;
        } else {
            x = MathUtils.randomBoolean() ? 0f : GDXGAME.WORLD_WIDTH;
            y = MathUtils.random(0.2f, GDXGAME.WORLD_HEIGHT);
        }

    }

    public void direction() {
        float angle = 0;
        if (x == 0) {
            angle = MathUtils.random(-30f, 30f);
        } else if (x == GDXGAME.WORLD_WIDTH) {
            angle = MathUtils.random(150f, 210f);
        } else if (y == 0) {
            angle = MathUtils.random(60f, 120f);
        } else if (y == 9) {
            angle = MathUtils.random(-120f, -60f);
        }

        direction = new Vector2(MathUtils.cosDeg(angle), MathUtils.sinDeg(angle));
    }


    public void update(float delta) {
        circle.x += direction.x * speed * delta;
        circle.y += direction.y * speed * delta;
        screenWrapping();
    }

    public void screenWrapping() {
        if (circle.x - circle.radius > GDXGAME.WORLD_WIDTH) circle.x = -circle.radius;
        if (circle.x + circle.radius < 0) circle.x = GDXGAME.WORLD_WIDTH + circle.radius;

        if (circle.y - circle.radius > GDXGAME.WORLD_HEIGHT) circle.y = -circle.radius;
        if (circle.y + circle.radius < 0) circle.y = GDXGAME.WORLD_HEIGHT + circle.radius;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, circle.x - drawRadius, circle.y - drawRadius, drawRadius * 2, drawRadius * 2);
    }


}

