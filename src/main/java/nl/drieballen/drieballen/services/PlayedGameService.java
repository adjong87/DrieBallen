package nl.drieballen.drieballen.services;

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
import java.util.Optional;

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

    public List<PlayedGame> getAllPlayedGames(){
        List<PlayedGame> playedGameList = playedGameRepository.findAll();
        return playedGameList;
    }

    public void createPlayedGame(String playerOne, String playerTwo){
        Member p1 = memberRepository.findById(playerOne).orElse(null);
        Member p2 = memberRepository.findById(playerTwo).orElse(null);
        ScoreCard sC = new ScoreCard();
        scoreCardRepository.save(sC);
        PlayedGameId id1 = new PlayedGameId(playerOne, sC.getId());
        PlayedGameId id2 = new PlayedGameId(playerTwo, sC.getId());
        PlayedGame pg1 = new PlayedGame(id1, p1, sC);
        PlayedGame pg2 = new PlayedGame(id2, p2, sC);
        playedGameRepository.save(pg1);
        playedGameRepository.save(pg2);

    }

//    public void matchMemberToScoreCard(String playerOne, String playerTwo, Long scoreCardId){
//        var playedGameP1 = new PlayedGame();
//        var playedGameP2 = new PlayedGame();
//        if (!scoreCardRepository.existsById(scoreCardId)) {throw new RecordNotFoundException();}
//        ScoreCard sC = scoreCardRepository.findById(scoreCardId).orElse(null);
//        if (!memberRepository.existsById(playerOne)) {throw new RecordNotFoundException();}
//        Member p1 = memberRepository.findById(playerOne).orElse(null);
//        PlayedGameId id1 = new PlayedGameId(playerOne, scoreCardId);
//        Member p2 = memberRepository.findById(playerTwo).orElse(null);
//        PlayedGameId id2 = new PlayedGameId(playerTwo, scoreCardId);
//        playedGameP1.setMember(p1);
//        playedGameP1.setScoreCard(sC);
//        playedGameP1.setId(id1);
//        playedGameP2.setMember(p2);
//        playedGameP2.setScoreCard(sC);
//        playedGameP2.setId(id2);
//        playedGameRepository.save(playedGameP1);
//        playedGameRepository.save(playedGameP2);
//        p1.addPlayedGame(playedGameP1);
//        p2.addPlayedGame(playedGameP2);
//        sC.addPlayedGame(playedGameP1);
//        sC.addPlayedGame(playedGameP2);
//        memberRepository.save(p1);
//        memberRepository.save(p2);
//        scoreCardRepository.save(sC);
//
//    }
}
