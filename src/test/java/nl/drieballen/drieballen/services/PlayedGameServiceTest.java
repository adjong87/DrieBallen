package nl.drieballen.drieballen.services;

import nl.drieballen.drieballen.models.PlayedGame;
import nl.drieballen.drieballen.models.Profile;
import nl.drieballen.drieballen.models.ScoreCard;
import nl.drieballen.drieballen.repositories.PlayedGameRepository;
import nl.drieballen.drieballen.repositories.ProfileRepository;
import nl.drieballen.drieballen.repositories.ScoreCardRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PlayedGameServiceTest {

    @Mock
    private PlayedGameRepository pg2PlayedGameRepository;
    @Mock
    private ProfileRepository testprofileRepository;
    @Mock
    private ScoreCardRepository scoreCardRepository;
    private PlayedGameService underTest;

    @BeforeEach
    void setUp() {
        underTest = new PlayedGameService(
                testprofileRepository, scoreCardRepository, pg2PlayedGameRepository);


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void canFindPlayedGameById() {
        // when
        underTest.findPlayedGameById("testUser");

        // then
        verify(pg2PlayedGameRepository).findPlayedGamesById_UsernameContainingIgnoreCaseAndScoreCard_FilledInIsTrue("testUser");
    }


    @Test
    void findPlayedGamesByScoreCardId() {
        //when
        underTest.findPlayedGamesByScoreCardId(10L);
        //then
        verify(pg2PlayedGameRepository).findPlayedGamesById_Id(10L);
    }

    @Test
    void createPlayedGame() {
        //given
        ScoreCard scoreCard = new ScoreCard("test", "test2", 30, 30);
        Profile profile = new Profile("testUser", "test", "test", 55, 30, gender);
        Profile profile2 = new Profile("testUser2", "test2", "test2", 45, 40, gender);
        Long id = scoreCard.getId();
        //when
        when(testprofileRepository.getById("testUser"))
                .thenReturn(profile);
        when(testprofileRepository.getById("testUser2"))
                .thenReturn(profile2);

        PlayedGame expected = new PlayedGame(profile, scoreCard);

        //then
        assertSame(expected, underTest);

    }

    @Test
    void toDto() {
    }
}