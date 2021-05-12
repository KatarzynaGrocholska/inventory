package pl.project.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.inventory.entity.User;
import pl.project.inventory.entity.Wine;
import pl.project.inventory.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private  UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);

    }

    @Override
    public User getUserById(Integer id) {

        Optional<User> optional= userRepository.findById(id);
        User user = null;
        if(optional.isPresent()){
            user= optional.get();
        }else {
            throw new RuntimeException("Nie znaleziono takiego uzytkownika w bazie danych");
        }
        return user;
    }


    @Override
    public void deleteUserByID(Integer id) {
        this.userRepository.deleteById(id);

    }
}
