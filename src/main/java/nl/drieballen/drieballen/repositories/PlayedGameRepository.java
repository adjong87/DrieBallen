package nl.drieballen.drieballen.repositories;

import nl.drieballen.drieballen.models.PlayedGame;
import nl.drieballen.drieballen.models.PlayedGameId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayedGameRepository extends JpaRepository<PlayedGame, PlayedGameId> {

    List<PlayedGame> findPlayedGamesById_UsernameContainingIgnoreCase(String username);
    List<PlayedGame> findAllByIdContaining(String username);

}
