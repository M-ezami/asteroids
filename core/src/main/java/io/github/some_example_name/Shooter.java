package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Shooter {
    private final static float MIDX = GDXGAME.WORLD_WIDTH / 2;
    private final static float MIDY = GDXGAME.WORLD_HEIGHT / 2;
    private final static float SPEED = 2f;
    private final static float RADIUS = 0.5f;
    private Vector2 position;
    private Circle circle;
    private float rotation;
    private TextureRegion shooterIdleTexture;
    private TextureRegion shooterAcceleratingTexture;
    private TextureRegion shooterTexture;
    private Vector2 direction = new Vector2();



    public Shooter(Assets assets) {
        position = new Vector2(MIDX, MIDY);
        this.circle = new Circle(position, RADIUS);
        shooterTexture = assets.getShooter();
        shooterIdleTexture = assets.getShooter();
        shooterAcceleratingTexture = assets.getAcceleratingShooter();

    }

    public void setDirection() {
        direction.set(1, 0);         // start pointing along X axis
        direction.setAngleDeg(rotation); // rotate it by your rotation in degrees
        direction.nor();             // optional, makes it length 1
    }

    public boolean collision(Circle asteroid){
        return (circle.overlaps(asteroid));
    }

    public void shoot(){

    }

    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            shooterTexture = shooterIdleTexture;
            rotation += 90 * delta;

        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            shooterTexture = shooterIdleTexture;
            rotation -= 90 * delta;

        }

        setDirection();

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            shooterTexture = shooterAcceleratingTexture;
            circle.x += direction.x * SPEED * delta;
            circle.y += direction.y * SPEED * delta;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            shooterTexture = shooterIdleTexture;
            circle.x -= direction.x * SPEED * delta;
            circle.y -= direction.y * SPEED * delta;
        }
    }


    public void draw(SpriteBatch batch) {
        batch.draw(shooterTexture,
            circle.x-RADIUS, circle.y-RADIUS,
            RADIUS, RADIUS,
            RADIUS * 2, RADIUS * 2,
            1f, 1f,
            rotation);
    }



}
