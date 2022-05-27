package com.example.game.Models;

import javafx.scene.image.Image;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class User {
    private String username;
    private String password;
    private boolean isLoggedIn;
    //    private Image avatar;
//    private URL avatarURL;
    private int score;
    private int avatarNumber;

    public User(String username, String password, boolean isLoggedIn) {
        this.username = username;
        this.password = password;
        this.isLoggedIn = isLoggedIn;
        this.score = 0;
        //////////////// random avatar ///////////////
        int max = 9;
        int min = 1;
        this.avatarNumber = (int)Math.floor(Math.random()*(max-min+1)+min);
//        JLabel userImage = new JLabel(new ImageIcon("@../img/avatars/5.png"));
//        this.avatar = new Image("/img/avatars/" + randomNum + ".png");
//        this.avatarURL = new URL("/img/avatar/" + randomNum + ".png");
        //////////////// random avatar ///////////////
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

//    public Image getAvatar() {
//        return avatar;
//    }
//
//    public void setAvatar(Image avatar) {
//        this.avatar = avatar;
//    }

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
//
//    public URL getAvatarURL() {
//        return avatarURL;
//    }
//
//    public void setAvatarURL(URL avatarURL) {
//        this.avatarURL = avatarURL;
//    }
}