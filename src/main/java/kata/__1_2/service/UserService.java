package kata.__1_2.service;

import kata.__1_2.domain.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(Long id);
    void saveUser(User user);
    void deleteUser(Long id);
}
