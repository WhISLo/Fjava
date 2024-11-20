package com.example.dao;

import com.example.model.User;
import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(Long id);
    void deleteUser(Long id);
}
