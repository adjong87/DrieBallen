package nl.drieballen.drieballen.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class ScoreCard {


    public ScoreCard() {
    }

    public ScoreCard(String playerOneName, String playerTwoName, int aimScoreP1, int aimScoreP2) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.aimScoreP1 = aimScoreP1;
        this.aimScoreP2 = aimScoreP2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String playerOneName;

    private String playerTwoName;

    @ElementCollection
    private List<Integer> playerOneScore;

    @ElementCollection
    private List<Integer> playerTwoScore;
    private int aimScoreP1;

    private int aimScoreP2;

    private int nrOfTurns;

    private LocalDate gespeeldOp = LocalDate.now();

    @JsonIgnore
    @OneToMany(mappedBy = "scoreCard")
    private Collection<PlayedGame> playedGames;

    private boolean filledIn;

    // ----- GETTERS ------------

    public Long getId() {
        return id;
    }

    public String getPlayerOneName() {
        return playerOneName;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public List<Integer> getPlayerOneScore() {
        return playerOneScore;
    }

    public List<Integer> getPlayerTwoScore() {
        return playerTwoScore;
    }

    public int getAimScoreP1() {
        return aimScoreP1;
    }

    public int getAimScoreP2() {
        return aimScoreP2;
    }

    public int getNrOfTurns() {
        return nrOfTurns;
    }

    public LocalDate getGespeeldOp() {
        return gespeeldOp;
    }

    public Collection<PlayedGame> getPlayedGames() {
        return playedGames;
    }

    public boolean isFilledIn() {
        return filledIn;
    }

    // ----- SETTERS ------------


    public void setId(Long id) {
        this.id = id;
    }

    public void setPlayerOneScore(List<Integer> playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public void setPlayerTwoScore(List<Integer> playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }
//
//    public void setNrOfTurns(int nrOfTurns) {
//        this.nrOfTurns = playerOneScore.length;
//    }

    public void setGespeeldOp(LocalDate gespeeldOp) {
        this.gespeeldOp = gespeeldOp;
    }

    public void setPlayedGames(Collection<PlayedGame> playedGames) {
        this.playedGames = playedGames;
    }

    public void addPlayedGame(PlayedGame playedGame){
        playedGames.add(playedGame);
    }

    public void setFilledIn(boolean filledIn) {
        this.filledIn = filledIn;
    }
}
