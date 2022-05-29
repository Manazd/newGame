package com.example.game.Models;

public class GameLevel {
    private int level;
    private int primaryLives;
    private int hit;
    private int power;

    public GameLevel(int level) {
        if (level == 1) {
            setGameLevel(1, 10, 1, 3);
        } else if (level == 2) {
            setGameLevel(2, 5, 2, 2);
        } else {
            setGameLevel(3, 2, 3, 1);
        }
    }

    private void setGameLevel(int level, int primaryLives, int hit, int power) {
        this.level = level;
        this.primaryLives = primaryLives;
        this.hit = hit;
        this.power = power;
    }

    public int getPrimaryLives() {
        return primaryLives;
    }

    public void setPrimaryLives(int primaryLives) {
        this.primaryLives = primaryLives;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
