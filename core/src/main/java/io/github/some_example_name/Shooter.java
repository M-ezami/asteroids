package io.github.some_example_name;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Shooter {

    private final static float MIDX = GDXGAME.WORLD_WIDTH / 2;
    private final static float MIDY = GDXGAME.WORLD_HEIGHT / 2;
    private final static float SPEED = 2f;
    private final static float RADIUS = 0.5f;

    private TextureRegion shooterIdleTexture;
    private TextureRegion shooterAcceleratingTexture;
    private TextureRegion shooterTexture;

    private Vector2 startingPosition;
    private Circle circle;
    private float rotation;
    private Vector2 direction = new Vector2();
    private Assets assets;


    public Shooter(Assets assets) {
        this.assets = assets;
        startingPosition = new Vector2(MIDX, MIDY);
        this.circle = new Circle(startingPosition, RADIUS);
        loadAssets();
        direction.set(1, 0);

    }

    public Circle getCircle() {
        return circle;
    }

    public boolean outOfScreen() {
        if (circle.x + RADIUS > GDXGAME.WORLD_WIDTH || circle.y + RADIUS > GDXGAME.WORLD_HEIGHT) {
            return true;
        }
        return false;
    }


    public void loadAssets() {
        shooterTexture = assets.getShooter();
        shooterIdleTexture = assets.getShooter();
        shooterAcceleratingTexture = assets.getAcceleratingShooter();

    }

    public Vector2 getDirection() {
        return direction;
    }

    public void setDirection() {
        direction.setAngleDeg(rotation);
        direction.nor();
    }

    public boolean collision(Circle asteroid) {
        return (circle.overlaps(asteroid));
    }


    public void updateDirection(float delta, float rotationValue) {
        shooterTexture = shooterIdleTexture;

        float rotationalSpeed = 130;
        rotation += rotationValue * rotationalSpeed * delta;
        setDirection();
    }

    public void updateMovement(float delta) {
        shooterTexture = shooterAcceleratingTexture;

        circle.x += direction.x * SPEED * delta;
        circle.y += direction.y * SPEED * delta;
    }


    public void draw(SpriteBatch batch) {
        batch.draw(shooterTexture,
            circle.x - RADIUS, circle.y - RADIUS,
            RADIUS, RADIUS,
            RADIUS * 2, RADIUS * 2,
            1f, 1f,
            rotation);
    }


}
