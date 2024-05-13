package co.udea.airline.api.model.jpa.repository;

import co.udea.airline.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByMail(String mail);
}
