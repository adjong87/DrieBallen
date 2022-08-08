package nl.drieballen.drieballen.repositories;

import java.util.List;
import java.util.Optional;
import nl.drieballen.drieballen.models.ScoreCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScoreCardRepository extends JpaRepository<ScoreCard, Long> {

    List<ScoreCard> findScoreCardByFilledInIs(boolean b);

    Optional<ScoreCard> findByIdAndFilledInIsTrue(Long id);

    Optional<ScoreCard> findByIdAndFilledInIsFalse(Long id);
}
