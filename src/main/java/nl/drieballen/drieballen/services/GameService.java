package nl.drieballen.drieballen.services;

import nl.drieballen.drieballen.dtos.ScoreCardDto;
import nl.drieballen.drieballen.models.ScoreCard;
import nl.drieballen.drieballen.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<ScoreCardDto> getAllGames() {
        List<ScoreCardDto> scoreCardDtoList = new ArrayList<>();
        List<ScoreCard> scoreCardList = gameRepository.findAll();
        for (ScoreCard scoreCard : scoreCardList) {
            scoreCardDtoList.add(fromGame(scoreCard));
        }
        return scoreCardDtoList;
    }

    public ScoreCardDto createGame(ScoreCardDto scoreCardDto) {
        ScoreCard spel = toGame(scoreCardDto);
        gameRepository.save(spel);
        return scoreCardDto;
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

    private static ScoreCard toGame(ScoreCardDto scoreCardDto) {
        var game = new ScoreCard();
        game.setPlayerOneScore(scoreCardDto.getPlayerOneScore());
        game.setPlayerTwoScore(scoreCardDto.getPlayerTwoScore());
        game.setBilliard(scoreCardDto.getBilliard());
        game.setNrOfTurns(scoreCardDto.getNrOfTurns());
        return game;
    }

    public static ScoreCardDto fromGame(ScoreCard scoreCard) {
        var dto = new ScoreCardDto();
        dto.setPlayerOneScore(scoreCard.getPlayerOneScore());
        dto.setPlayerTwoScore(scoreCard.getPlayerTwoScore());
        dto.setBilliard(scoreCard.getBilliard());
        dto.setNrOfTurns(scoreCard.getNrOfTurns());
        return dto;
    }
}
