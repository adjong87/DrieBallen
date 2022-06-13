package nl.drieballen.drieballen.controllers;

import nl.drieballen.drieballen.dtos.ScoreCardDto;
import nl.drieballen.drieballen.services.ScoreCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/scorecards")
public class ScoreCardController {

    private final ScoreCardService scoreCardService;

    @Autowired
    public ScoreCardController(ScoreCardService scoreCardService) {
        this.scoreCardService = scoreCardService;
    }

    @GetMapping("")
    public ResponseEntity<List<ScoreCardDto>> getAllScoreCards(){
        List<ScoreCardDto> scoreCardDtoList;
        scoreCardDtoList = scoreCardService.getAllScoreCards();
        return ResponseEntity.ok().body(scoreCardDtoList);
    }

    @PostMapping("")
    public ScoreCardDto createScoreCard(@RequestBody ScoreCardDto dto) {
        ScoreCardDto scoreCardDto = scoreCardService.createScoreCard(dto);
        return scoreCardDto;
    }

    @PostMapping("/{playerOne}/{playerTwo}/{scoreCardId}")
    public void matchMemberToScoreCard(@PathVariable("playerOne") String playerOne, @PathVariable("playerTwo") String playerTwo, @PathVariable("scoreCardId") Long scoreCardId){
        scoreCardService.matchMemberToScoreCard(playerOne, playerTwo, scoreCardId);
    }

}
