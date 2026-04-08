package io.github.some_example_name;

public enum Level {
    LEVEL1(1, 1, 2),
    LEVEL2(2, 3, 4),
    LEVEL3(3, 5, 6);

    public final int smallSize;
    public final int mediumSize;
    public final int bigSize;


    Level(int smallSize, int mediumSize, int bigSize) {
        this.smallSize = smallSize;
        this.mediumSize = mediumSize;
        this.bigSize = bigSize;
    }


    public int getSmallSize() {
        return smallSize;
    }

    public int getMediumSize(){
        return mediumSize;
    }

    public int getBigSize(){
        return bigSize;
    }

    public Level nextLevel() {
        Level[] levels = values();
        int ordinal = this.ordinal();
        if (ordinal + 1 < levels.length) {
            return levels[ordinal + 1];
        } else {
            return levels[0]; // wrap around to LEVEL1 if you want
        }
    }

}
