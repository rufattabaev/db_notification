package service;

import enumeration.UserStatus;
import model.User;
import repository.UserRepository;

public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User doRegistration(String login, String password) {
        User user = new User();
        user.setFirstName(login);
        user.setLastName(password);
        user.setStatus(UserStatus.UNKNOWN);
        repository.doRegistration(user);
        return user;
    }
}
