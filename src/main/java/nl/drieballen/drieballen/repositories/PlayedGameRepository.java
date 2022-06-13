package nl.drieballen.drieballen.repositories;

import nl.drieballen.drieballen.models.PlayedGame;
import nl.drieballen.drieballen.models.PlayedGameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayedGameRepository extends JpaRepository<PlayedGame, PlayedGameId> {


}
