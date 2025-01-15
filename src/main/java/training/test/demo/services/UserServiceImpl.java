package training.test.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import training.test.demo.entities.User;
import training.test.demo.repositories.UserRepository;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {

        if (user.getId() != null) { // Si l'ID n'est pas null, on vérifie si l'utilisateur existe
            Optional<User> userFound = userRepository.findById(user.getId());
            if (userFound.isPresent()) {
                throw new IllegalArgumentException("L'utilisateur existe déjà avec cet ID : " + user.getId());
            }
        }
        String password = passwordEncoder.encode(user.getPassword());
        System.out.println("Mot de passe pou "+ user.getPassword()+ " est: "+password);
        user.setPassword(password);
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User update(User user) {

        Optional<User> userFound = userRepository.findById(user.getId());

        if (userFound.isPresent()) {
            User u=userFound.get();
            u.setEmail(user.getEmail());
            u.setName(user.getName());
            System.out.println("Hash pour " +user.getPassword()+ " :"+passwordEncoder.encode(user.getPassword()));
            u.setPassword(passwordEncoder.encode(user.getPassword()));
            return  userRepository.save(u);
        }
        return userRepository.save(user) ;
    }


    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByEmail(String email) {
        User user= userRepository.fincUserByEmail(email);
        if (user!=null) {
            return user;
        }else {
            return  null;
        }
    }

    @Override
    public Boolean userConnexion(Long id) {
        Optional<User> user = userRepository.findById(id);
//        if (user.isPresent()){
//            return  user.get().getConnected();
//        }
        return false;
    }
}
