package nl.drieballen.drieballen.repositories;

import java.util.Optional;
import nl.drieballen.drieballen.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {

    void deleteByUsername(String username);

    Optional<Profile> findByUsername(String username);

}
