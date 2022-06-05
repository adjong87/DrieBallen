package nl.drieballen.drieballen.repositories;

import nl.drieballen.drieballen.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {


}
