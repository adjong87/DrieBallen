package nl.drieballen.drieballen.repositories;

import nl.drieballen.drieballen.models.PlayedGame;
import nl.drieballen.drieballen.models.PlayedGameId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayedGameRepository extends JpaRepository<PlayedGame, PlayedGameId> {

    List<PlayedGame> findPlayedGamesById_UsernameContainingIgnoreCase(String username);
    List<PlayedGame> findAllByIdContaining(String username);

    List<PlayedGame> findPlayedGamesById_Id(Long id);

    List<PlayedGame> findPlayedGamesById_UsernameContainingIgnoreCaseAndScoreCard_FilledInIsTrue(String username);
}
