package nl.drieballen.drieballen.controllers;

import nl.drieballen.drieballen.dtos.ScoreCardDto;
import nl.drieballen.drieballen.dtos.ScoreCardInputDto;
import nl.drieballen.drieballen.models.ScoreCard;
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
    public ScoreCardDto createScoreCard(@RequestBody ScoreCardInputDto ScoreCardInputDto) {
        ScoreCardDto scoreCardDto= scoreCardService.createScoreCard(ScoreCardInputDto);
        return scoreCardDto;
    }

    @PutMapping("/update/{id}")
    public ScoreCardDto updateScoreCard(@PathVariable("id") Long id, @RequestBody ScoreCardInputDto scoreCardInputDto){
        ScoreCardDto dto = scoreCardService.updateScoreCard(id, scoreCardInputDto);
        return dto;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteScoreCard(@PathVariable("id") Long id){
        scoreCardService.deleteScoreCard(id);
        return "Scorecard " + id + " is verwijderd";
    }
}
