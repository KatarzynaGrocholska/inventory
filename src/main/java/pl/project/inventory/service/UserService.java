package pl.project.inventory.service;

import pl.project.inventory.entity.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(Integer id);
    void deleteUserByID(Integer id);
}
