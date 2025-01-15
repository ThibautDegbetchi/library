package training.test.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import training.test.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from users u where u.email=?1")
    User fincUserByEmail( String email);

}
