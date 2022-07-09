package nl.drieballen.drieballen.controllers;

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

    @GetMapping(value = "/donecard")
    public ResponseEntity<ScoreCardDto> getFinishedScoreCard(@RequestParam("id") Long id){
        ScoreCardDto dto = scoreCardService.getFinishedScoreCard(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/card")
    public ResponseEntity<ScoreCardDto> getScoreCard(@RequestParam("id") Long id){
        ScoreCardDto dto = scoreCardService.getScoreCard(id);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/fill")
    public ScoreCardDto fillInScore(@RequestParam(value = "id") Long id, @RequestBody ScoreCardInputDto scoreCardInputDto){
        return scoreCardService.fillInScore(id, scoreCardInputDto);
    }
}
