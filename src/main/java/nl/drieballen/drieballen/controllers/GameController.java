package nl.drieballen.drieballen.controllers;

import nl.drieballen.drieballen.dtos.ScoreCardDto;
import nl.drieballen.drieballen.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("")
    public ResponseEntity<List<ScoreCardDto>> getAllGames(){
        List<ScoreCardDto> scoreCardDtoList;
        scoreCardDtoList = gameService.getAllGames();
        return ResponseEntity.ok().body(scoreCardDtoList);
    }

    @PostMapping("")
    public ScoreCardDto createGame(@RequestBody ScoreCardDto dto) {
        ScoreCardDto scoreCardDto = gameService.createGame(dto);
        return scoreCardDto;
    }

}
