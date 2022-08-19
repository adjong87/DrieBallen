package nl.drieballen.drieballen.repositories;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

import nl.drieballen.drieballen.models.PlayedGame;
import nl.drieballen.drieballen.models.Profile;
import nl.drieballen.drieballen.models.ScoreCard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class PlayedGameRepositoryTest {

    @Autowired
    private PlayedGameRepository pGTestRepository;

    @BeforeEach
    void setUp() {


    }

    @AfterEach
    void tearDown() {
        pGTestRepository.deleteAll();
    }





    @Test
    void itShouldFindPlayedGamesByPlayedGameId_Id() {
        //given
        ScoreCard scoreCard = new ScoreCard("test", "test", 30, 30);
        Long id = scoreCard.getId();
        PlayedGame playedGame = new PlayedGame(
                new Profile("testUser", "test", "test", 55, 30, gender), scoreCard);

        //when
        List<PlayedGame> expectedList = pGTestRepository.findPlayedGamesById_Id(id);

        //then
        assertThat(expectedList.size() == 1);
    }

    @Test
    void findPlayedGamesById_UsernameContainingIgnoreCaseAndScoreCard_FilledInIsTrue() {
    }
}