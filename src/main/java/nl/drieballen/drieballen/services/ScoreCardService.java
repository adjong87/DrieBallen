package nl.drieballen.drieballen.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import nl.drieballen.drieballen.dtos.ScoreCardDto;
import nl.drieballen.drieballen.dtos.ScoreCardInputDto;
import nl.drieballen.drieballen.exceptions.RecordNotFoundException;
import nl.drieballen.drieballen.models.ScoreCard;
import nl.drieballen.drieballen.repositories.ScoreCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreCardService {

    private final ScoreCardRepository scoreCardRepository;

    @Autowired
    public ScoreCardService(ScoreCardRepository scoreCardRepository) {
        this.scoreCardRepository = scoreCardRepository;
    }

    public List<ScoreCardDto> getAllNonFilled() {
        List<ScoreCardDto> scoreCardDtoList = new ArrayList<>();
        List<ScoreCard> scoreCardList = scoreCardRepository.findScoreCardByFilledInIs(false);
        for (ScoreCard scoreCard : scoreCardList) {
            scoreCardDtoList.add(fromScoreCard(scoreCard));
        }
        return scoreCardDtoList;
    }

    public ScoreCardDto getFinishedScoreCard(Long id) {
        Optional<ScoreCard> scoreCard = scoreCardRepository.findByIdAndFilledInIsTrue(id);
        if (scoreCard.isPresent()) {
            return fromScoreCard(scoreCard.get());
        } else {
            throw new RecordNotFoundException("deze scorecard bestaat niet finished");
        }
    }

    public ScoreCardDto getScoreCard(Long id) {
        Optional<ScoreCard> scoreCard = scoreCardRepository.findById(id);
        if (scoreCard.isPresent()) {
            return fromScoreCard(scoreCard.get());
        } else {
            throw new RecordNotFoundException("deze scorecard bestaat niet unfinished");
        }
    }

    public ScoreCardDto fillInScore(Long id, ScoreCardInputDto scoreCardInputDto) {
        ScoreCard sc = scoreCardRepository.findByIdAndFilledInIsFalse(id)
                .orElseThrow(() -> new RecordNotFoundException("Wedstrijd nummer: " + id + " is al gespeeld"));
        Objects.requireNonNull(sc).setId(id);
        sc.setHighestSerieP1(scoreCardInputDto.getHighestSerieP1());
        sc.setHighestSerieP2(scoreCardInputDto.getHighestSerieP2());
        sc.setRemainderP1(scoreCardInputDto.getRemainderP1());
        sc.setRemainderP2(scoreCardInputDto.getRemainderP2());
        sc.setAverageP1(scoreCardInputDto.getAverageP1());
        sc.setAverageP2(scoreCardInputDto.getAverageP2());
        sc.setNrOfTurns(scoreCardInputDto.getNrOfTurns());
        sc.setFilledIn(true);
        scoreCardRepository.save(sc);
        return fromScoreCard(sc);
    }

    public static ScoreCardDto fromScoreCard(ScoreCard scoreCard) {
        var dto = new ScoreCardDto();
        dto.setId(scoreCard.getId());
        dto.setPlayerOneName(scoreCard.getPlayerOneName());
        dto.setPlayerTwoName(scoreCard.getPlayerTwoName());
        dto.setHighestSerieP1(scoreCard.getHighestSerieP1());
        dto.setHighestSerieP2(scoreCard.getHighestSerieP2());
        dto.setAimScoreP1(scoreCard.getAimScoreP1());
        dto.setAimScoreP2(scoreCard.getAimScoreP2());
        dto.setRemainderP1(scoreCard.getRemainderP1());
        dto.setRemainderP2(scoreCard.getRemainderP2());
        dto.setAverageP1(scoreCard.getAverageP1());
        dto.setAverageP2(scoreCard.getAverageP2());
        dto.setNrOfTurns(scoreCard.getNrOfTurns());
        dto.setGespeeldOp(scoreCard.getGespeeldOp());
        return dto;
    }
}
