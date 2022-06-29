package nl.drieballen.drieballen.repositories;

import nl.drieballen.drieballen.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    void deleteByUsername(String username);
}
