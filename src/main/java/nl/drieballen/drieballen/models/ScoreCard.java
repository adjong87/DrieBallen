package nl.drieballen.drieballen.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

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

    private int[] playerOneScore;

    private int[] playerTwoScore;
    private int aimScoreP1;

    private int aimScoreP2;

    private int remainderP1;

    private int remainderP2;

    private int nrOfTurns;

    private LocalDate gespeeldOp = LocalDate.now();

    @JsonIgnore
    @OneToMany(mappedBy = "scoreCard", cascade = CascadeType.ALL)
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

    public int[] getPlayerOneScore() {
        return playerOneScore;
    }

    public int[] getPlayerTwoScore() {
        return playerTwoScore;
    }

    public int getAimScoreP1() {
        return aimScoreP1;
    }

    public int getAimScoreP2() {
        return aimScoreP2;
    }

    public int getRemainderP1() {
        return remainderP1;
    }

    public int getRemainderP2() {
        return remainderP2;
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

    public void setPlayerOneName(String playerOneName) {
        this.playerOneName = playerOneName;
    }

    public void setPlayerTwoName(String playerTwoName) {
        this.playerTwoName = playerTwoName;
    }

    public void setPlayerOneScore(int[] playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public void setPlayerTwoScore(int[] playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }

    public void setAimScoreP1(int aimScoreP1) {
        this.aimScoreP1 = aimScoreP1;
    }

    public void setAimScoreP2(int aimScoreP2) {
        this.aimScoreP2 = aimScoreP2;
    }

    public void setRemainderP1(int remainderP1) {
        this.remainderP1 = remainderP1;
    }

    public void setRemainderP2(int remainderP2) {
        this.remainderP2 = remainderP2;
    }

    public void setNrOfTurns(int nrOfTurns) {
        this.nrOfTurns = playerOneScore.length;
    }

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
