package nl.drieballen.drieballen.dtos;

import java.time.LocalDate;

public class ScoreCardDto {

    private Long Id;

    private String playerOneName;

    private String playerTwoName;

    private int[] playerOneScore;

    private int[] playerTwoScore;

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

    public void setNrOfTurns(int nrOfTurns) {
        this.nrOfTurns = nrOfTurns;
    }

    public void setGespeeldOp(LocalDate gespeeldOp) {
        this.gespeeldOp = gespeeldOp;
    }
}
