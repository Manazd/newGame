package com.example.game.Controllers;

import com.example.game.Models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private static ArrayList<User> users = new ArrayList<>();
    private static User loggedInUser;

    public static void loadUsers() {
        try {
            ArrayList<User> loadUsers = new ArrayList<>();
            String json = new String(Files.readAllBytes(Paths.get("./src/main/Database/userDatabase.json")));
            loadUsers = new Gson().fromJson(json , new TypeToken<List<User>>(){}.getType());
            if (loadUsers != null) users = loadUsers;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        if (users.isEmpty()) {
            users = new ArrayList<>();
        }
    }
    public static void saveUsers()  {
        try {
            FileWriter fileWriter = new FileWriter("./src/main/Database/userDatabase.json");
            fileWriter.write(new Gson().toJson(users));
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static User getUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    public static User getUserByUsername(String username) {
        if (users.size() != 0) {
            for (User user : users) {
                if (user.getUsername().equals(username))
                    return user;
            }
        }
        return null;
    }

    public static void createUser(String username, String password) {
        User newUser = new User(username, password, true);
        addUser(newUser);
        setLoggedInUser(newUser);
    }

    public static void login(User user) {
        user.setLoggedIn(true);
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        UserController.loggedInUser = loggedInUser;
    }

    public static void removeUser(User user) {
        users.remove(user);
    }
}
