package com.mycompany.fantasygame.controller;

import java.sql.SQLException;
import java.util.List;
import com.mycompany.fantasygame.model.UserDAO;
import com.mycompany.fantasygame.model.User;

public class UserController {

    private final UserDAO userDAO;

    public UserController() {
        this.userDAO = new UserDAO();
    }

    public User createUser(User user) {
        try {
            return userDAO.createUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> getAllUsers() {
        try {
            return userDAO.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getUserById(String id) {
        try {
            return userDAO.getUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateUser(User user) {
        try {
            return userDAO.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(String id) {
        try {
            return userDAO.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
