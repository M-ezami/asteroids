package io.github.some_example_name;

public enum AsteroidSize {
    SMALL(0.35f),
    MEDIUM(0.7f),
    BIG(1.15f);

    public final float radius;

    AsteroidSize(float radius) {
        this.radius = radius;
    }


}
