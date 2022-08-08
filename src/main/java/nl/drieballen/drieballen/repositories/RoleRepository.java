package nl.drieballen.drieballen.repositories;

import java.util.Optional;
import nl.drieballen.drieballen.models.ERole;
import nl.drieballen.drieballen.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
