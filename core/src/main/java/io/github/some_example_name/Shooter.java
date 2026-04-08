package io.github.some_example_name;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Shooter {

    private final static float MIDX = GDXGAME.WORLD_WIDTH / 2;
    private final static float MIDY = GDXGAME.WORLD_HEIGHT / 2;
    private final static float RADIUS = 0.5f;

    private TextureRegion shooterIdleTexture;
    private TextureRegion shooterAcceleratingTexture;
    private TextureRegion shooterTexture;

    private Vector2 startingPosition;
    private Circle circle;
    private float rotation;
    private Vector2 direction = new Vector2();
    private Assets assets;

    // Inertia / movement
    private Vector2 velocity = new Vector2();
    private float acceleration = 3f; // thrust per second
    private float friction = 0.99f;  // slows gradually
    private float maxSpeed = 20f;     // speed cap

    public Shooter(Assets assets) {
        this.assets = assets;
        startingPosition = new Vector2(MIDX, MIDY);
        this.circle = new Circle(startingPosition, RADIUS);
        loadAssets();
        direction.set(1, 0); // initial facing right
    }

    public Circle getCircle() {
        return circle;
    }

    public boolean outOfScreen() {
        return circle.x + RADIUS > GDXGAME.WORLD_WIDTH
            || circle.y + RADIUS > GDXGAME.WORLD_HEIGHT;
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
        direction.setAngleDeg(rotation).nor();
    }

    public boolean collision(Circle asteroid) {
        return circle.overlaps(asteroid);
    }

    public void updateDirection(float delta, float rotationValue) {
        shooterTexture = shooterIdleTexture;
        float rotationalSpeed = 130f;
        rotation += rotationValue * rotationalSpeed * delta;
        setDirection();
    }

    public void updateMovement(float delta, boolean thrusting) {
        if (thrusting) shooterTexture = shooterAcceleratingTexture;
        else shooterTexture = shooterIdleTexture;


        if (thrusting) {
            Vector2 accelVector = new Vector2(direction).scl(acceleration);
            velocity.add(accelVector.scl(delta));
        }

        if (velocity.len() > maxSpeed) velocity.nor().scl(maxSpeed);

        circle.x += velocity.x * delta;
        circle.y += velocity.y * delta;

        velocity.scl(friction);
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
