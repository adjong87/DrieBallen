package nl.drieballen.drieballen.controllers;

import nl.drieballen.drieballen.models.PlayedGame;
import nl.drieballen.drieballen.services.PlayedGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/chairman")
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
    public ResponseEntity<List<PlayedGame>> getAllPlayedGamesByFirstName(@RequestParam(value = "username") String username){
        List<PlayedGame> playedGameList;
        playedGameList = playedGameService.findPlayedGameById(username);
        return ResponseEntity.ok().body(playedGameList);
    }

    @PostMapping("/createGame")
    public void createPlayedGame(@RequestParam(value = "playerOne") String playerOne, @RequestParam(value = "playerTwo") String playerTwo) {
        playedGameService.createPlayedGame(playerOne, playerTwo);
    }
}
