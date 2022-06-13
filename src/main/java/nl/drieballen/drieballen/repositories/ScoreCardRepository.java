package nl.drieballen.drieballen.repositories;

import nl.drieballen.drieballen.models.ScoreCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreCardRepository extends JpaRepository<ScoreCard, Long> {
}
