package nl.drieballen.drieballen.services;

import nl.drieballen.drieballen.dtos.ScoreCardDto;
import nl.drieballen.drieballen.dtos.ScoreCardInputDto;
import nl.drieballen.drieballen.exceptions.RecordNotFoundException;
import nl.drieballen.drieballen.models.ScoreCard;
import nl.drieballen.drieballen.repositories.ScoreCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreCardService {

    private final ScoreCardRepository scoreCardRepository;


    @Autowired
    public ScoreCardService(ScoreCardRepository scoreCardRepository) {
        this.scoreCardRepository = scoreCardRepository;
    }

    public List<ScoreCardDto> getAllScoreCards() {
        List<ScoreCardDto> scoreCardDtoList = new ArrayList<>();
        List<ScoreCard> scoreCardList = scoreCardRepository.findAll();
        for (ScoreCard scoreCard : scoreCardList) {
            scoreCardDtoList.add(fromScoreCard(scoreCard));
        }
        return scoreCardDtoList;
    }

    public ScoreCardDto createScoreCard(ScoreCardInputDto scoreCardInputDto) {
        ScoreCard scoreCard = toScoreCard(scoreCardInputDto);
        scoreCardRepository.save(scoreCard);
        return fromScoreCard(scoreCard);
    }

    public ScoreCardDto updateScoreCard(Long id, ScoreCardInputDto scoreCardInputDto) {
        if(!scoreCardRepository.existsById(id)) {
            throw new RecordNotFoundException("No scorecard found");
        }
        ScoreCard sc = scoreCardRepository.findById(id).orElse(null);
        sc.setId(id);
        sc.setPlayerOneScore(scoreCardInputDto.getPlayerOneScore());
        sc.setPlayerTwoScore(scoreCardInputDto.getPlayerTwoScore());
        sc.setNrOfTurns(scoreCardInputDto.getPlayerOneScore().length);
        scoreCardRepository.save(sc);
        return fromScoreCard(sc);
    }

    public void deleteScoreCard(Long id){
        scoreCardRepository.deleteById(id);
    }

    private static ScoreCard toScoreCard(ScoreCardInputDto scoreCardInputDto) {
        var scoreCard = new ScoreCard();
        scoreCard.setPlayerOneScore(scoreCardInputDto.getPlayerOneScore());
        scoreCard.setPlayerTwoScore(scoreCardInputDto.getPlayerTwoScore());
        if (scoreCardInputDto.getPlayerOneScore().length <= 30) {
            scoreCard.setNrOfTurns(scoreCardInputDto.getPlayerOneScore().length);
        } else {
            throw new RecordNotFoundException("aantal beurten klopt niet");        }
        return scoreCard;
    }

    public static ScoreCardDto fromScoreCard(ScoreCard scoreCard) {
        var dto = new ScoreCardDto();
        dto.setId(scoreCard.getId());
        dto.setPlayerOneScore(scoreCard.getPlayerOneScore());
        dto.setPlayerTwoScore(scoreCard.getPlayerTwoScore());
        dto.setNrOfTurns(scoreCard.getNrOfTurns());
        return dto;
    }

}
