package nl.drieballen.drieballen.services;

import nl.drieballen.drieballen.exceptions.RecordNotFoundException;
import nl.drieballen.drieballen.models.Member;
import nl.drieballen.drieballen.models.PlayedGame;
import nl.drieballen.drieballen.models.PlayedGameId;
import nl.drieballen.drieballen.models.ScoreCard;
import nl.drieballen.drieballen.repositories.MemberRepository;
import nl.drieballen.drieballen.repositories.PlayedGameRepository;
import nl.drieballen.drieballen.repositories.ScoreCardRepository;

public class PlayedGameService {

    private final MemberRepository memberRepository;

    private final ScoreCardRepository scoreCardRepository;

    private final PlayedGameRepository playedGameRepository;

    public PlayedGameService(MemberRepository memberRepository, ScoreCardRepository scoreCardRepository, PlayedGameRepository playedGameRepository) {
        this.memberRepository = memberRepository;
        this.scoreCardRepository = scoreCardRepository;
        this.playedGameRepository = playedGameRepository;
    }

    public void matchMemberToScoreCard(String playerOne, String playerTwo, Long scoreCardId){
        var playedGameP1 = new PlayedGame();
        var playedGameP2 = new PlayedGame();
        if (!memberRepository.existsById(playerOne)) {throw new RecordNotFoundException();}
        Member p1 = memberRepository.findById(playerOne).orElse(null);
        PlayedGameId id1 = new PlayedGameId(playerOne, scoreCardId);
        Member p2 = memberRepository.findById(playerTwo).orElse(null);
        PlayedGameId id2 = new PlayedGameId(playerTwo, scoreCardId);
        if (!scoreCardRepository.existsById(scoreCardId)) {throw new RecordNotFoundException();}
        ScoreCard sC = scoreCardRepository.findById(scoreCardId).orElse(null);
        playedGameP1.setMember(p1);
        playedGameP1.setScoreCard(sC);
        playedGameP1.setId(id1);
        playedGameP2.setMember(p2);
        playedGameP2.setScoreCard(sC);
        playedGameP2.setId(id2);
    }

//    public void assignMembersToGame(Long playerOne, Long playerTwo, Long gameId) {
//        var optionalPlayerOne = memberRepository.findById(playerOne);
//        var optionalPlayerTwo = memberRepository.findById(playerTwo);
//        var optionalGame = gameRepository.findById(gameId);
//        if (optionalPlayerOne.isPresent() && optionalPlayerTwo.isPresent() && optionalGame.isPresent()) {
//            var game = optionalGame.get();
//            var player1 = optionalPlayerOne.get();
//            var player2 = optionalPlayerTwo.get();
//            game.setPlayerOne(player1);
//            game.setPlayerTwo(player2);
//            player1.setPlayedGames(game);
//            gameRepository.save(game);
//        } else {
//            throw new RecordNotFoundException();
//        }
//    }

}
