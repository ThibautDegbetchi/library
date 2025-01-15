package training.test.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import training.test.demo.entities.Preference;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, String> {
}
