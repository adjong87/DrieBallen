package nl.drieballen.drieballen.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class ScoreCard {

    @Id
    @GeneratedValue
    private Long id;

    private int[] playerOneScore;

    private int[] playerTwoScore;

    private String billiard;

    private int nrOfTurns;

    private LocalDateTime gespeeldOp;

    @JsonIgnore
    @OneToMany(mappedBy = "scoreCard")
    private Collection<PlayedGame> playedGames;
    // ----- GETTERS ------------

    public Long getId() {
        return id;
    }

    public int[] getPlayerOneScore() {
        return playerOneScore;
    }

    public int[] getPlayerTwoScore() {
        return playerTwoScore;
    }

    public String getBilliard() {
        return billiard;
    }

    public int getNrOfTurns() {
        return nrOfTurns;
    }

    public LocalDateTime getGespeeldOp() {
        return gespeeldOp;
    }

    public Collection<PlayedGame> getPlayedGames() {
        return playedGames;
    }

    // ----- SETTERS ------------


    public void setId(Long id) {
        this.id = id;
    }

    public void setPlayerOneScore(int[] playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public void setPlayerTwoScore(int[] playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }

    public void setBilliard(String billiard) {
        this.billiard = billiard;
    }

    public void setNrOfTurns(int nrOfTurns) {
        this.nrOfTurns = nrOfTurns;
    }

    public void setGespeeldOp(LocalDateTime gespeeldOp) {
        this.gespeeldOp = gespeeldOp;
    }

    public void setPlayedGames(Collection<PlayedGame> playedGames) {
        this.playedGames = playedGames;
    }
}
