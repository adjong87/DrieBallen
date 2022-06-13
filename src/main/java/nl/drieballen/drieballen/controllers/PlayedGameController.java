package nl.drieballen.drieballen.controllers;

import nl.drieballen.drieballen.services.PlayedGameService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/referee")
public class PlayedGameController {

    private final PlayedGameService playedGameService;

    public PlayedGameController(PlayedGameService playedGameService) {
        this.playedGameService = playedGameService;
    }

    @PostMapping("/{playerOne}/{playerTwo}/{scoreCardId}")
    public void matchMemberToScoreCard(@PathVariable("playerOne") String playerOne, @PathVariable("playerTwo") String playerTwo, @PathVariable("scoreCardId") Long scoreCardId){
        playedGameService.matchMemberToScoreCard(playerOne, playerTwo, scoreCardId);
    }

}
