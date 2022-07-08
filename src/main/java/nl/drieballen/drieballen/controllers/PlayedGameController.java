package nl.drieballen.drieballen.controllers;

import nl.drieballen.drieballen.dtos.PlayedGameDto;
import nl.drieballen.drieballen.exceptions.BadRequestException;
import nl.drieballen.drieballen.services.PlayedGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/playedgame")
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
    public ResponseEntity<List<PlayedGameDto>> getAllPlayedGamesByUsername(@RequestParam(value = "username") String username){
        List<PlayedGameDto> playedGameDtoList;
        playedGameDtoList = playedGameService.findPlayedGameById(username);
        return ResponseEntity.ok().body(playedGameDtoList);
    }

    @GetMapping("/findbyid")
    public ResponseEntity<List<PlayedGameDto>> getUsernamesByScId(@RequestParam(value = "id") Long id){
        List<PlayedGameDto> playedGameDtoList;
        playedGameDtoList = playedGameService.findPlayedGamesByScoreCardId(id);
        return ResponseEntity.ok().body(playedGameDtoList);
    }


    @PostMapping("/createGame")
    public String createPlayedGame(@RequestParam(value = "playerOne") String playerOne, @RequestParam(value = "playerTwo") String playerTwo) {
        if (!Objects.equals(playerOne, playerTwo)) {
            playedGameService.createPlayedGame(playerOne, playerTwo);
            return "game created";
        } else throw new BadRequestException("Twee dezelfde spelers geselecteerd");
    }
}
