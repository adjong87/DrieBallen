package nl.drieballen.drieballen.controllers;

import nl.drieballen.drieballen.models.PlayedGame;
import nl.drieballen.drieballen.services.PlayedGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/referee")
public class PlayedGameController {

    private final PlayedGameService playedGameService;

    public PlayedGameController(PlayedGameService playedGameService) {
        this.playedGameService = playedGameService;
    }

    @GetMapping
    public ResponseEntity<List<PlayedGame>> getAllPlayedGames() {
        List<PlayedGame> playedGameList;
        playedGameList = playedGameService.getAllPlayedGames();
        return ResponseEntity.ok().body(playedGameList);
    }

//    @PostMapping("/playedgame")
//    public void createPlayedGame(@RequestParam(value = "playerOne") String playerOne, @RequestParam(value = "playerTwo") String playerTwo, @RequestParam(value = "scoreCard") Long id) {
//        playedGameService.matchMemberToScoreCard(playerOne, playerTwo, id);
//    }

    @PostMapping("/playedgame")
    public void createPlayedGame(@RequestParam(value = "playerOne") String playerOne, @RequestParam(value = "playerTwo") String playerTwo) {
        playedGameService.createPlayedGame(playerOne, playerTwo);
    }

    //    @PostMapping("/{playerOne}/{playerTwo}/{scoreCardId}")
//    public void matchMemberToScoreCard(@PathVariable("playerOne") String playerOne, @PathVariable("playerTwo") String playerTwo, @PathVariable("scoreCardId") Long scoreCardId){
//        playedGameService.matchMemberToScoreCard(playerOne, playerTwo, scoreCardId);
//    }

}
