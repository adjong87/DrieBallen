package nl.drieballen.drieballen.controllers;

import nl.drieballen.drieballen.dtos.PlayedGameDto;
import nl.drieballen.drieballen.models.PlayedGame;
import nl.drieballen.drieballen.services.PlayedGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/playedGame")
public class PlayedGameController {

    private final PlayedGameService playedGameService;

    public PlayedGameController(PlayedGameService playedGameService) {
        this.playedGameService = playedGameService;
    }

//    @GetMapping("/")
//    public ResponseEntity<List<PlayedGame>> getAllPlayedGames() {
//        List<PlayedGame> playedGameList;
//        playedGameList = playedGameService.getAllPlayedGames();
//        return ResponseEntity.ok().body(playedGameList);
//    }

    @GetMapping("/find")
    public ResponseEntity<List<PlayedGameDto>> getAllPlayedGamesByFirstName(@RequestParam(value = "username") String username){
        List<PlayedGameDto> playedGameDtoList;
        playedGameDtoList = playedGameService.findPlayedGameById(username);
        return ResponseEntity.ok().body(playedGameDtoList);
    }

    @PostMapping("/createGame")
    public void createPlayedGame(@RequestParam(value = "playerOne") String playerOne, @RequestParam(value = "playerTwo") String playerTwo) {
        playedGameService.createPlayedGame(playerOne, playerTwo);
    }
}
