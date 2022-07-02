package nl.drieballen.drieballen.dtos;

import javax.persistence.ElementCollection;
import java.time.LocalDate;
import java.util.List;

public class ScoreCardDto {

    private Long Id;

    private String playerOneName;

    private String playerTwoName;

    @ElementCollection
    private List<Integer> playerOneScore;
    @ElementCollection
    private List<Integer> playerTwoScore;
    private int aimScoreP1;

    private int aimScoreP2;

    private int nrOfTurns;

    private LocalDate gespeeldOp;


    // ------ CONSTRUCTORS

    public ScoreCardDto() {
    }

    // ------ GETTERS

    public Long getId() {
        return Id;
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

    // ------ SETTERS


    public void setId(Long id) {
        Id = id;
    }

    public void setPlayerOneName(String playerOneName) {
        this.playerOneName = playerOneName;
    }

    public void setPlayerTwoName(String playerTwoName) {
        this.playerTwoName = playerTwoName;
    }

    public void setPlayerOneScore(List<Integer> playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public void setPlayerTwoScore(List<Integer> playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }

    public void setAimScoreP1(int aimScoreP1) {
        this.aimScoreP1 = aimScoreP1;
    }

    public void setAimScoreP2(int aimScoreP2) {
        this.aimScoreP2 = aimScoreP2;
    }

    public void setNrOfTurns(int nrOfTurns) {
        this.nrOfTurns = nrOfTurns;
    }

    public void setGespeeldOp(LocalDate gespeeldOp) {
        this.gespeeldOp = gespeeldOp;
    }
}
