package nl.drieballen.drieballen.repositories;
import nl.drieballen.drieballen.models.ERole;
import nl.drieballen.drieballen.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);


}
