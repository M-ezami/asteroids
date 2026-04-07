package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;

public class Assets {

    TextureRegion firstBigSteroid;
    TextureRegion secondBigSteroid;
    TextureRegion thirdBigSteroid;
    TextureRegion firstMediumSteroid;
    TextureRegion secondMediumSteroid;
    TextureRegion thirdMediumSteroid;
    TextureRegion firstSmallSteroid;
    TextureRegion secondSmallSteroid;
    TextureRegion thirdSmallSteroid;
    TextureRegion shooter;
    TextureRegion acceleratingShooter;

    List<TextureRegion> bigAsteroids;
    List<TextureRegion> mediumAsteroids;
    List<TextureRegion> smallAsteroids;
    TextureRegion bullet;
    TextureRegion bullet2;
    TextureRegion bullet3;

    Texture bulletTexture;
    private Texture mainTexture;

    public void load() {
        mainTexture = new Texture(Gdx.files.internal("asteroids-2x.png"));
        bulletTexture = new Texture(Gdx.files.internal("pixel-art-illustration-bullet-pixelated-600nw-2445516995.png"));
        // Big asteroids — 160×160 cells, top row (y = 0)
        firstBigSteroid = new TextureRegion(mainTexture, 0, 0, 160, 160);
        secondBigSteroid = new TextureRegion(mainTexture, 160, 0, 160, 160);
        thirdBigSteroid = new TextureRegion(mainTexture, 320, 0, 160, 160);

        // Medium asteroids — 96×96 cells, second row (y = 160)
        firstMediumSteroid = new TextureRegion(mainTexture, 0, 160, 96, 96);
        secondMediumSteroid = new TextureRegion(mainTexture, 96, 160, 96, 96);
        thirdMediumSteroid = new TextureRegion(mainTexture, 192, 160, 96, 96);

        // Saucer/ship — 96×80, far right of the medium row (x = 384)
        shooter = new TextureRegion(mainTexture, 384, 160, 96, 80);

        // Small asteroids — 64×64 cells, third row (y = 256)
        firstSmallSteroid = new TextureRegion(mainTexture, 0, 256, 64, 64);
        secondSmallSteroid = new TextureRegion(mainTexture, 64, 256, 64, 64);
        thirdSmallSteroid = new TextureRegion(mainTexture, 128, 256, 64, 64);

        // Arrow ships (player) — 96×64 cells, same row (x = 192 and 288)
        shooter = new TextureRegion(mainTexture, 192, 256, 96, 64);
        acceleratingShooter = new TextureRegion(mainTexture, 288, 256, 96, 64);


        bullet = new TextureRegion(mainTexture, 384, 256, 32, 32);
        bullet2 = new TextureRegion(mainTexture, 416, 256, 32, 32);
        bullet3 = new TextureRegion(bulletTexture,227,108,148,387);
        // Bullets — 32×32 each, bottom-right corner (x = 384, 416)
        // Add TextureRegion fields for these if you need them:
        // bullet  = new TextureRegion(mainTexture, 384, 256, 32, 32);
        // bullet2 = new TextureRegion(mainTexture, 416, 256, 32, 32);
    }

    public TextureRegion getBullet3() {
        return bullet3;
    }

    public List<TextureRegion> getAllBigAsteroids() {
        bigAsteroids = new ArrayList<>();
        bigAsteroids.add(firstBigSteroid);
        bigAsteroids.add(secondBigSteroid);
        bigAsteroids.add(thirdBigSteroid);
        return bigAsteroids;
    }

    public List<TextureRegion> getAllMediumAsteroids() {
        mediumAsteroids = new ArrayList<>();
        mediumAsteroids.add(firstMediumSteroid);
        mediumAsteroids.add(secondMediumSteroid);
        mediumAsteroids.add(thirdMediumSteroid);
        return mediumAsteroids;
    }

    public List<TextureRegion> getAllSmallAsteroids() {
        smallAsteroids = new ArrayList<>();
        smallAsteroids.add(firstSmallSteroid);
        smallAsteroids.add(secondSmallSteroid);
        smallAsteroids.add(thirdSmallSteroid);
        return smallAsteroids;
    }

    public TextureRegion getFirstBigSteroid() {
        return firstBigSteroid;
    }

    public TextureRegion getSecondBigSteroid() {
        return secondBigSteroid;
    }

    public TextureRegion getThirdBigSteroid() {
        return thirdBigSteroid;
    }

    public TextureRegion getFirstMediumSteroid() {
        return firstMediumSteroid;
    }

    public TextureRegion getSecondMediumSteroid() {
        return secondMediumSteroid;
    }

    public TextureRegion getThirdMediumSteroid() {
        return thirdMediumSteroid;
    }

    public TextureRegion getFirstSmallSteroid() {
        return firstSmallSteroid;
    }

    public TextureRegion getSecondSmallSteroid() {
        return secondSmallSteroid;
    }

    public TextureRegion getThirdSmallSteroid() {
        return thirdSmallSteroid;
    }

    public TextureRegion getShooter() {
        return shooter;
    }

    public TextureRegion getAcceleratingShooter() {
        return acceleratingShooter;
    }

    public TextureRegion getBullet() {
        return bullet;
    }

    public TextureRegion getBullet2() {
        return bullet2;
    }


    public void dispose(){
        mainTexture.dispose();
        bulletTexture.dispose();
    }
}
