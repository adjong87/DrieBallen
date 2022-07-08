package nl.drieballen.drieballen.services;

import nl.drieballen.drieballen.dtos.PlayedGameDto;
import nl.drieballen.drieballen.dtos.ProfileDto;
import nl.drieballen.drieballen.exceptions.RecordNotFoundException;
import nl.drieballen.drieballen.models.Profile;
import nl.drieballen.drieballen.models.PlayedGame;
import nl.drieballen.drieballen.models.PlayedGameId;
import nl.drieballen.drieballen.models.ScoreCard;
import nl.drieballen.drieballen.repositories.ProfileRepository;
import nl.drieballen.drieballen.repositories.PlayedGameRepository;
import nl.drieballen.drieballen.repositories.ScoreCardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayedGameService {

    private final ProfileRepository profileRepository;

    private final ScoreCardRepository scoreCardRepository;

    private final PlayedGameRepository playedGameRepository;

    public PlayedGameService(ProfileRepository profileRepository, ScoreCardRepository scoreCardRepository, PlayedGameRepository playedGameRepository) {
        this.profileRepository = profileRepository;
        this.scoreCardRepository = scoreCardRepository;
        this.playedGameRepository = playedGameRepository;
    }

//    public List<PlayedGame> getAllPlayedGames(){
//        List<PlayedGame> playedGameList = playedGameRepository.findAll();
//        return playedGameList;
//    }

    public List<PlayedGameDto> findPlayedGameById(String username){
        List<PlayedGameDto> playedGameDtoList = new ArrayList<>();
        List<PlayedGame> playedGameList = playedGameRepository.findPlayedGamesById_UsernameContainingIgnoreCaseAndScoreCard_FilledInIsTrue(username);
        for(PlayedGame playedGame : playedGameList){
            playedGameDtoList.add(toDto(playedGame));
        }
        return playedGameDtoList;
    }

    public List<PlayedGameDto> findPlayedGamesByScoreCardId(Long id){
        List<PlayedGameDto> playedGameDtoList = new ArrayList<>();
        List<PlayedGame> playedGameList = playedGameRepository.findPlayedGamesById_Id(id);
        for(PlayedGame playedGame : playedGameList){
            playedGameDtoList.add(toDto(playedGame));
        }
        return playedGameDtoList;
    }

    public void createPlayedGame(String playerOne, String playerTwo){
        Profile p1 = profileRepository.findByUsername(playerOne).
                orElseThrow(() -> new RecordNotFoundException("username " + playerOne + " doesn't exist"));
        Profile p2 = profileRepository.findByUsername(playerTwo).
                orElseThrow(() -> new RecordNotFoundException("username " + playerTwo + " doesn't exist"));
        ScoreCard sC =
                new ScoreCard(p1.getFirstName(), p2.getFirstName(), p1.getAimScore(), p2.getAimScore());
        sC.setFilledIn(false);
        scoreCardRepository.save(sC);
        PlayedGame pg1 = new PlayedGame(new PlayedGameId(playerOne, sC.getId()), p1, sC);
        PlayedGame pg2 = new PlayedGame(new PlayedGameId(playerTwo, sC.getId()), p2, sC);
        p1.addPlayedGame(pg1);
        p2.addPlayedGame(pg2);
        profileRepository.save(p1);
        profileRepository.save(p2);
    }

    public PlayedGameDto toDto(PlayedGame playedGame){
        PlayedGameDto playedGameDto = new PlayedGameDto();
        playedGameDto.setScoreCard(playedGame.getScoreCard());
        playedGameDto.setProfile(playedGame.getProfile());
        playedGameDto.setUitgespeeld(playedGame.isUitgespeeld());
        return playedGameDto;
    }
}
