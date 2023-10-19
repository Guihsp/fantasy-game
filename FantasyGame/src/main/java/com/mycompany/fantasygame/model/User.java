package com.mycompany.fantasygame.model;
import java.util.List;

public class User {

    private String id;
    private String name;
    private String userPerfil;
    private String email;
    private String password;
    private List<Task> tasks;

    public User() {
    }

    public User(String id, String name, String userPerfil, String email, String password) {
        this.id = id;
        this.name = name;
        this.userPerfil = userPerfil;
        this.email = email;
        this.password = password;
    }

    public User(String id, String name, String userPerfil, String email, String password, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.userPerfil = userPerfil;
        this.email = email;
        this.password = password;
        this.tasks = tasks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserPerfil() {
        return userPerfil;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserPerfil(String userPerfil) {
        this.userPerfil = userPerfil;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
