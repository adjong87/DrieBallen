package nl.drieballen.drieballen.services;

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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class PlayedGameServiceTest {

    @InjectMocks
    private PlayedGameService playedGameService;
    @Mock
    private PlayedGameRepository playedGameRepository;
    @Mock
    private ScoreCardRepository scoreCardRepository;

    @Mock
    private ProfileRepository profileRepository;

//    @Test
//    @DisplayName("Test should pass if PlayedGame contains username that was put in that is part of PlayedGame id and scorecard filled_in is true")
//    void ShouldFindFinishedPlayedGameByUsername() {
//        var profile1 = new Profile("pieterpost", "Pieter", "Post", 55, 33);
//        var profile2 = new Profile("dikkiedik", "Dikkie", "Dik", 54, 25);
//
//        var scoreCard = new ScoreCard("pieter", "dikkie", 33, 25);
//        Long id = Long.valueOf(1);
//        scoreCard.setId(id);
//        scoreCard.setFilledIn(false);
//
//        var scoreCard2 = new ScoreCard("dikkie", "pieterpost", 25, 33);
//        scoreCard2.setFilledIn(true);
//        Long id2 = Long.valueOf(2);
//        scoreCard.setId(id2);
//
//        var playedGame1 = new PlayedGame(
//                new PlayedGameId("pieterpost", scoreCard.getId()), profile1, scoreCard);
//
//        var playedGame2 = new PlayedGame(
//                new PlayedGameId("dikkiedik", scoreCard.getId()), profile2, scoreCard);
//
//        var playedGame3 = new PlayedGame(
//                new PlayedGameId("dikkiedik", scoreCard2.getId()), profile1, scoreCard2);
//
//        var playedGame4 = new PlayedGame(
//                new PlayedGameId("pieterpost", scoreCard2.getId()),
//                profile2, scoreCard2);
//        scoreCardRepository.save(scoreCard);
//        scoreCardRepository.save(scoreCard2);
//        playedGameRepository.save(playedGame1);
//        playedGameRepository.save(playedGame2);
//        playedGameRepository.save(playedGame3);
//        playedGameRepository.save(playedGame4);
//
//        var response = new ArrayList<PlayedGame>();
//
//        response.add(playedGame4);
//
//        Mockito
//                .when(playedGameRepository.findPlayedGamesById_UsernameContainingIgnoreCaseAndScoreCard_FilledInIsTrue("pieterpost"))
//                .thenReturn(response);
//
//        List<PlayedGameDto> found = playedGameService.findPlayedGameById("pieterpost");
//
//        assertEquals(response.size(), found.size());
//    }

    @Test
    @DisplayName("Test should not pass if PlayedGame contains username that was put in that is part of PlayedGame id and scorecard filled_in is false")
    void ShouldNotFindPlayedGameWithNotFilledInScoreCardByUsername() {
        var profile1 = new Profile("pieterpost", "Pieter", "Post", 55, 33);
        var profile2 = new Profile("dikkiedik", "Dikkie", "Dik", 54, 25);

        var scoreCard = new ScoreCard("pieter", "dikkie", 33, 25);
        scoreCard.setFilledIn(false);

        var scoreCard2 = new ScoreCard("dikkie", "pieterpost", 25, 33);
        scoreCard2.setFilledIn(true);


        var playedGame1 = new PlayedGame(
                new PlayedGameId("pieterpost", scoreCard.getId()), profile1, scoreCard2);

        var playedGame2 = new PlayedGame(
                new PlayedGameId("dikkiedik", scoreCard.getId()), profile2, scoreCard);

        var playedGame3 = new PlayedGame(
                new PlayedGameId("dikkiedik", scoreCard2.getId()), profile1, scoreCard2);

        var playedGame4 = new PlayedGame(
                new PlayedGameId("pieterpost", scoreCard2.getId()),
                profile2, scoreCard2);

        var response = new ArrayList<PlayedGame>();

        response.add(playedGame1);
        response.add(playedGame2);
        response.add(playedGame3);
        response.add(playedGame4);

        when(playedGameRepository.findPlayedGamesById_UsernameContainingIgnoreCaseAndScoreCard_FilledInIsTrue("pieterpost")).thenReturn(response);

        List<PlayedGameDto> found = playedGameService.findPlayedGameById("pieterpost");
        assertEquals(response.size(), found.size());

    }

    @Test
    void shouldFindBothProfilesByPlayedGameScoreCardId() {
        var profile1 = new Profile("pieterpost", "Pieter", "Post", 55, 33);
        var profile2 = new Profile("dikkiedik", "Dikkie", "Dik", 54, 25);
        var scoreCard = new ScoreCard("pieter", "dikkie", 33, 25);
        scoreCard.setFilledIn(false);
        scoreCard.setId(10L);
        var scoreCard2 = new ScoreCard("dikkie", "pieter", 25, 33);
        scoreCard2.setFilledIn(true);
        var playedGame1 = new PlayedGame(
                new PlayedGameId("pieterpost", scoreCard.getId()), profile1, scoreCard);
        var playedGame2 = new PlayedGame(
                new PlayedGameId("dikkiedik", scoreCard.getId()), profile2, scoreCard);

        var response = new ArrayList<PlayedGame>();
        response.add(playedGame1);
        response.add(playedGame2);
        when(playedGameRepository.findPlayedGamesById_Id(10L)).thenReturn(response);
        assertEquals(playedGame1.getId().getUsername(),playedGameService.findPlayedGamesByScoreCardId(10L).get(0).getProfile().getUsername());

    }

    @Test
    void shouldCreateGame() {
        var profile1 = new Profile("pieterpost", "Pieter", "Post", 55, 33);
        var profile2 = new Profile("dikkiedik", "Dikkie", "Dik", 54, 25);
        var scoreCard = new ScoreCard("pieter", "dikkie", 33, 25);
        scoreCard.setFilledIn(false);
        scoreCard.setId(10L);
        var scoreCard2 = new ScoreCard("dikkie", "pieter", 25, 33);
        scoreCard2.setFilledIn(true);
        var playedGame1 = new PlayedGame(
                new PlayedGameId("pieterpost", scoreCard.getId()), profile1, scoreCard);
        var playedGame2 = new PlayedGame(
                new PlayedGameId("dikkiedik", scoreCard.getId()), profile2, scoreCard);

        var response = new ArrayList<PlayedGame>();
        response.add(playedGame1);
        response.add(playedGame2);

    }

    @Test
    void toDto() {
    }

    @Test
    void fromDto() {
    }


}