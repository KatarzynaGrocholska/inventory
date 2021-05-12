package pl.project.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.project.inventory.entity.User;
import pl.project.inventory.repository.UserRepository;

public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user =userRepository.getUserByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException("Nie znaleziono uzytkownika o takiej nazwie");
        }
        return new UserDetailsImp(user);
    }
}
