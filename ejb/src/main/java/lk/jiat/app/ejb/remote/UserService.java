package lk.jiat.app.ejb.remote;

import jakarta.ejb.Remote;
import lk.jiat.app.core.model.User;

@Remote
public interface UserService {
    User getUserById(Long id);
    User getUserByEmail(String email);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
}
