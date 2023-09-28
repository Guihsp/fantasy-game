package com.mycompany.fantasygame.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {

    private Connection connection;

    public UserDAO() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdatabase", "username",
                    "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        String sql = "SELECT id, name, userPerfil, email FROM users";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setUserPerfil(rs.getString("userPerfil"));
            user.setEmail(rs.getString("email"));
            users.add(user);
        }
        return users;
    }

    public User createUser(User user) throws SQLException {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        String sql = "INSERT INTO users (name, userPerfil, email, password) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, user.getName());
        ps.setString(2, user.getUserPerfil());
        ps.setString(3, user.getEmail());
        ps.setString(4, hashedPassword);
        int affectedRows = ps.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }

        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getString(1));
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }

        return user;
    }

    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET name = ?, userPerfil = ?, email = ? = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getUserPerfil());
        ps.setString(3, user.getEmail());
        ps.setString(5, user.getId());

        int affectedRows = ps.executeUpdate();

        return affectedRows > 0;
    }

    public User getUserById(String id) throws SQLException {
        String sql = "SELECT id, name, userPerfil, email FROM users WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setUserPerfil(rs.getString("userPerfil"));
            user.setEmail(rs.getString("email"));
            return user;
        } else {
            return null;
        }
    }

    public boolean deleteUser(String id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, id);

        int affectedRows = ps.executeUpdate();

        return affectedRows > 0;
    }
}
