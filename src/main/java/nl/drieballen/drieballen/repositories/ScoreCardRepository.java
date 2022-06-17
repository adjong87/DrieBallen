package nl.drieballen.drieballen.repositories;

import nl.drieballen.drieballen.models.ScoreCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreCardRepository extends JpaRepository<ScoreCard, Long> {

    List<ScoreCard> findScoreCardByFilledInIs(boolean b);
}
