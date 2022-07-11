package nl.drieballen.drieballen.services;

import nl.drieballen.drieballen.DrieBallenApplication;
import nl.drieballen.drieballen.dtos.PlayedGameDto;
import nl.drieballen.drieballen.models.PlayedGame;
import nl.drieballen.drieballen.models.PlayedGameId;
import nl.drieballen.drieballen.models.Profile;
import nl.drieballen.drieballen.models.ScoreCard;
import nl.drieballen.drieballen.repositories.PlayedGameRepository;
import nl.drieballen.drieballen.repositories.ProfileRepository;
import nl.drieballen.drieballen.repositories.ScoreCardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

@SpringBootTest
@ContextConfiguration(classes = {DrieBallenApplication.class})
public class PlayedGameServiceTest {

    @Autowired
    private PlayedGameService playedGameService;

    @MockBean
    private PlayedGameRepository playedGameRepository;
    private ScoreCardRepository scoreCardRepository;
    private ProfileRepository profileRepository;

    @Mock
    ScoreCard scoreCard;
    ScoreCard scoreCard2;

    @Mock
    PlayedGame playedGame1;
    PlayedGame playedGame2;
    PlayedGame playedGame4;
    PlayedGame playedGame3;
    @Mock
    Profile profile1;
    Profile profile2;



    @Test
    @DisplayName("Test should pass if PlayedGame contains username that was put in that is part of PlayedGame id and scorecard filled_in is true")
    void ShouldFindFinishedPlayedGameByUsername() {
        profile1 = new
                Profile("pieterpost", "Pieter", "Post", 55, 33);
        scoreCard = new
                ScoreCard("pieter", "dikkie", 33, 25);
        scoreCard.setFilledIn(false);
        playedGame1 = new
                PlayedGame(new PlayedGameId("pieterpost", scoreCard.getId()), profile1, scoreCard);
        var response = new ArrayList<PlayedGame>();
        response.add(playedGame1);

        Mockito
                .when(playedGameRepository.findPlayedGamesById_UsernameContainingIgnoreCaseAndScoreCard_FilledInIsTrue(profile1.getUsername()))
                .thenReturn(response);

        var found = playedGameService.findPlayedGameById("pieterpost");

        assertEquals(response.get(0).getProfile().getUsername(), found.get(0).getProfile().getUsername());
    }

    @Test
    @DisplayName("Test should not pass if PlayedGame contains username that was put in that is part of PlayedGame id and scorecard filled_in is false")
    void ShouldNotFindPlayedGameWithNotFilledInScoreCardByUsername() {
        profile1 = new
                Profile("pieterpost", "Pieter", "Post", 55, 33);
        profile2 = new
                Profile("dikkiedik", "Dikkie", "Dik", 54, 25);
        scoreCard = new
                ScoreCard("pieter", "dikkie", 33, 25);
        scoreCard2 = new
                ScoreCard("dikkie", "pieterpost", 25, 33);
        scoreCard.setFilledIn(false);
        scoreCard.setFilledIn(true);
        playedGame1 = new
                PlayedGame(new PlayedGameId("pieterpost", scoreCard.getId()), profile1, scoreCard);
        playedGame2 = new
                PlayedGame(new PlayedGameId("dikkiedik", scoreCard.getId()), profile2, scoreCard);
        playedGame3 = new
                PlayedGame(new PlayedGameId("dikkiedik", scoreCard2.getId()), profile1, scoreCard2);
        playedGame4 = new
                PlayedGame(new PlayedGameId("pieterpost", scoreCard2.getId()), profile2, scoreCard2);
        var response = new ArrayList<PlayedGame>();
        response.add(playedGame1);

        Mockito
                .when(playedGameRepository.findPlayedGamesById_UsernameContainingIgnoreCaseAndScoreCard_FilledInIsTrue(profile1.getUsername()))
                .thenReturn(response);

        var found = playedGameService.findPlayedGameById("pieterpost");

        assertNotEquals(playedGame1.getScoreCard().isFilledIn(), found.get(0).getScoreCard().isFilledIn());
    }

}