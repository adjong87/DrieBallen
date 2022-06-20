package nl.drieballen.drieballen.controllers;

import nl.drieballen.drieballen.dtos.MemberDto;
import nl.drieballen.drieballen.dtos.ScoreCardDto;
import nl.drieballen.drieballen.dtos.ScoreCardInputDto;
import nl.drieballen.drieballen.services.ScoreCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/scorecards")
public class ScoreCardController {

    private final ScoreCardService scoreCardService;

    @Autowired
    public ScoreCardController(ScoreCardService scoreCardService) {
        this.scoreCardService = scoreCardService;
    }

    @GetMapping("/referee")
    public ResponseEntity<List<ScoreCardDto>> getAllNonFilled(){
        List<ScoreCardDto>scoreCardDtoList;
        scoreCardDtoList = scoreCardService.getAllNonFilled();
        return ResponseEntity.ok().body(scoreCardDtoList);
    }


    @PutMapping("/correct")
    public ScoreCardDto correctScore(@RequestParam(value = "scoreCardNumber") Long id, @RequestBody ScoreCardInputDto scoreCardInputDto){
        ScoreCardDto dto = scoreCardService.correctScore(id, scoreCardInputDto);
        return dto;
    }

    @PutMapping("/fill")
    public ScoreCardDto fillInScore(@RequestParam(value = "scoreCardNumber") Long id, @RequestBody ScoreCardInputDto scoreCardInputDto){
        return scoreCardService.fillInScore(id, scoreCardInputDto);
    }

    @DeleteMapping("/delete")
    public String deleteScoreCard(@RequestParam(value = "id") Long id){
        scoreCardService.deleteScoreCard(id);
        return "Scorecard " + id + " is verwijderd";
    }
}
