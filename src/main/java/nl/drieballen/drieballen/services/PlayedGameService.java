package nl.drieballen.drieballen.services;

import nl.drieballen.drieballen.controllers.PlayedGameController;
import nl.drieballen.drieballen.exceptions.RecordNotFoundException;
import nl.drieballen.drieballen.models.Member;
import nl.drieballen.drieballen.models.PlayedGame;
import nl.drieballen.drieballen.models.PlayedGameId;
import nl.drieballen.drieballen.models.ScoreCard;
import nl.drieballen.drieballen.repositories.MemberRepository;
import nl.drieballen.drieballen.repositories.PlayedGameRepository;
import nl.drieballen.drieballen.repositories.ScoreCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayedGameService {

    private final MemberRepository memberRepository;

    private final ScoreCardRepository scoreCardRepository;

    private final PlayedGameRepository playedGameRepository;

    public PlayedGameService(MemberRepository memberRepository, ScoreCardRepository scoreCardRepository, PlayedGameRepository playedGameRepository) {
        this.memberRepository = memberRepository;
        this.scoreCardRepository = scoreCardRepository;
        this.playedGameRepository = playedGameRepository;
    }

//    public List<PlayedGame> getAllPlayedGames(){
//        List<PlayedGame> playedGameList = playedGameRepository.findAll();
//        return playedGameList;
//    }

    public List<PlayedGame> findPlayedGameById(String username){
        List<PlayedGame> playedGamesList = playedGameRepository.findPlayedGamesById_UsernameContainingIgnoreCase(username);
        return playedGamesList;
    }

    public void createPlayedGame(String playerOne, String playerTwo){
        Member p1 = memberRepository.findById(playerOne).
                orElseThrow(() -> new RecordNotFoundException("username " + playerOne + " doesn't exist"));
        Member p2 = memberRepository.findById(playerTwo).
                orElseThrow(() -> new RecordNotFoundException("username " + playerTwo + " doesn't exist"));
        ScoreCard sC =
                new ScoreCard(p1.getFirstName(), p2.getFirstName(), p1.getAimScore(), p2.getAimScore());
        scoreCardRepository.save(sC);
        PlayedGame pg1 = new PlayedGame(new PlayedGameId(playerOne, sC.getId()), p1, sC);
        PlayedGame pg2 = new PlayedGame(new PlayedGameId(playerTwo, sC.getId()), p2, sC);
        p1.addPlayedGame(pg1);
        p2.addPlayedGame(pg2);
        playedGameRepository.save(pg1);
        playedGameRepository.save(pg2);

    }
}
