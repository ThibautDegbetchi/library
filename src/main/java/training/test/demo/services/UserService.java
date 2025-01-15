package training.test.demo.services;


import training.test.demo.entities.User;

import java.util.List;

public interface UserService {
    public User save(User user);
    public void delete(User user);
    public User update(User user);
    public List<User> findAllUser();
    public User findUserByEmail(String email);
    public Boolean userConnexion(Long id);

}
