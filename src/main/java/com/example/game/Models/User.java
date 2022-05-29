package com.example.game.Models;

import javafx.scene.image.Image;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class User {
    private GameLevel gameLevel;
    private String username;
    private String password;
    private boolean isLoggedIn;
    private int score;
    private int avatarNumber;

    public User(String username, String password, boolean isLoggedIn) {
        this.username = username;
        this.password = password;
        this.isLoggedIn = isLoggedIn;
        this.score = 0;
        this.gameLevel = new GameLevel(2);
        this.avatarNumber = (int)Math.floor(Math.random()*10);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAvatarNumber() {
        return avatarNumber;
    }

    public void setAvatarNumber(int avatarNumber) {
        this.avatarNumber = avatarNumber;
    }

    public GameLevel getGameLevel() {
        return gameLevel;
    }

    public void setGameLevel(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }
}
