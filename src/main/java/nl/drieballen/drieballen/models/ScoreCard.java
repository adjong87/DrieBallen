package nl.drieballen.drieballen.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@Entity
public class ScoreCard {


    public ScoreCard() {
    }

    public ScoreCard(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String playerOneName;

    private String playerTwoName;

    private int[] playerOneScore;

    private int[] playerTwoScore;

    private int nrOfTurns;

    @CreationTimestamp
    private Calendar gespeeldOp;

    @JsonIgnore
    @OneToMany(mappedBy = "scoreCard")
    private Collection<PlayedGame> playedGames;

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

    public int[] getPlayerOneScore() {
        return playerOneScore;
    }

    public int[] getPlayerTwoScore() {
        return playerTwoScore;
    }

    public int getNrOfTurns() {
        return nrOfTurns;
    }

    public Calendar getGespeeldOp() {
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

    public void setNrOfTurns(int nrOfTurns) {
        this.nrOfTurns = playerOneScore.length;
    }

    public void setGespeeldOp(Calendar gespeeldOp) {
        this.gespeeldOp = gespeeldOp;
    }

    public void setPlayedGames(Collection<PlayedGame> playedGames) {
        this.playedGames = playedGames;
    }

    public void addPlayedGame(PlayedGame playedGame){
        playedGames.add(playedGame);
    }
}
