package nl.drieballen.drieballen.repositories;

import java.util.Optional;
import nl.drieballen.drieballen.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User> deleteByUsername(String username);
}
