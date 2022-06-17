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
import java.util.Objects;

@Service
public class ScoreCardService {

    private final ScoreCardRepository scoreCardRepository;


    @Autowired
    public ScoreCardService(ScoreCardRepository scoreCardRepository) {
        this.scoreCardRepository = scoreCardRepository;
    }

    public List<ScoreCardDto> getAllNonFilled(){
        List<ScoreCardDto> scoreCardDtoList = new ArrayList<>();
        List<ScoreCard> scoreCardList = scoreCardRepository.findScoreCardByFilledInIs(false);
        for (ScoreCard scoreCard : scoreCardList) {
            scoreCardDtoList.add(fromScoreCard(scoreCard));
        }
        return scoreCardDtoList;
    }

    public List<ScoreCardDto> getAllScoreCards() {
        List<ScoreCardDto> scoreCardDtoList = new ArrayList<>();
        List<ScoreCard> scoreCardList = scoreCardRepository.findAll();
        for (ScoreCard scoreCard : scoreCardList) {
            scoreCardDtoList.add(fromScoreCard(scoreCard));
        }
        return scoreCardDtoList;
    }

    public ScoreCardDto correctScore(Long id, ScoreCardInputDto scoreCardInputDto){
        ScoreCard sc = scoreCardRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("scorecard " + id + " doesn't exist"));
        Objects.requireNonNull(sc).setId(id);
        sc.setPlayerOneScore(scoreCardInputDto.getPlayerOneScore());
        sc.setPlayerTwoScore(scoreCardInputDto.getPlayerTwoScore());
        sc.setNrOfTurns(scoreCardInputDto.getPlayerOneScore().length);
        scoreCardRepository.save(sc);
        return fromScoreCard(sc);
    }

    public ScoreCardDto fillInScore(Long id, ScoreCardInputDto scoreCardInputDto) {
        ScoreCard sc = scoreCardRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Scorecard " + id + " doesn't exist"));
        Objects.requireNonNull(sc).setId(id);
        sc.setPlayerOneScore(scoreCardInputDto.getPlayerOneScore());
        sc.setPlayerTwoScore(scoreCardInputDto.getPlayerTwoScore());
        sc.setNrOfTurns(scoreCardInputDto.getPlayerOneScore().length);
        sc.setFilledIn(true);
        scoreCardRepository.save(sc);
        return fromScoreCard(sc);
    }

    public void deleteScoreCard(Long id){
        scoreCardRepository.deleteById(id);
    }

    public static ScoreCardDto fromScoreCard(ScoreCard scoreCard) {
        var dto = new ScoreCardDto();
        dto.setId(scoreCard.getId());
        dto.setPlayerOneName(scoreCard.getPlayerOneName());
        dto.setPlayerTwoName(scoreCard.getPlayerTwoName());
        dto.setPlayerOneScore(scoreCard.getPlayerOneScore());
        dto.setPlayerTwoScore(scoreCard.getPlayerTwoScore());
        dto.setAimScoreP1(scoreCard.getAimScoreP1());
        dto.setAimScoreP2(scoreCard.getAimScoreP2());
        dto.setNrOfTurns(scoreCard.getNrOfTurns());
        dto.setGespeeldOp(scoreCard.getGespeeldOp());
        return dto;
    }
}
