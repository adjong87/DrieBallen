package nl.drieballen.drieballen.repositories;

import nl.drieballen.drieballen.models.ScoreCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreCardRepository extends JpaRepository<ScoreCard, Long> {

    List<ScoreCard> findScoreCardByFilledInIs(boolean b);
}
