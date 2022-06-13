package nl.drieballen.drieballen.services;

import nl.drieballen.drieballen.dtos.ScoreCardDto;
import nl.drieballen.drieballen.exceptions.RecordNotFoundException;
import nl.drieballen.drieballen.models.Member;
import nl.drieballen.drieballen.models.PlayedGame;
import nl.drieballen.drieballen.models.PlayedGameId;
import nl.drieballen.drieballen.models.ScoreCard;
import nl.drieballen.drieballen.repositories.MemberRepository;
import nl.drieballen.drieballen.repositories.ScoreCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreCardService {

    private final ScoreCardRepository scoreCardRepository;

    private final MemberRepository memberRepository;

    @Autowired
    public ScoreCardService(ScoreCardRepository scoreCardRepository, MemberRepository memberRepository) {
        this.scoreCardRepository = scoreCardRepository;
        this.memberRepository = memberRepository;
    }

    public List<ScoreCardDto> getAllScoreCards() {
        List<ScoreCardDto> scoreCardDtoList = new ArrayList<>();
        List<ScoreCard> scoreCardList = scoreCardRepository.findAll();
        for (ScoreCard scoreCard : scoreCardList) {
            scoreCardDtoList.add(fromScoreCard(scoreCard));
        }
        return scoreCardDtoList;
    }

    public ScoreCardDto createScoreCard(ScoreCardDto scoreCardDto) {
        ScoreCard scoreCard = toScoreCard(scoreCardDto);
        scoreCardRepository.save(scoreCard);
        return scoreCardDto;
    }

    private static ScoreCard toScoreCard(ScoreCardDto scoreCardDto) {
        var game = new ScoreCard();
        game.setPlayerOneScore(scoreCardDto.getPlayerOneScore());
        game.setPlayerTwoScore(scoreCardDto.getPlayerTwoScore());
        game.setNrOfTurns(scoreCardDto.getNrOfTurns());
        return game;
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
