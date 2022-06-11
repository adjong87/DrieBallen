package nl.drieballen.drieballen.dtos;

import java.time.LocalDateTime;

public class ScoreCardDto {

    private int[] playerOneScore;

    private int[] playerTwoScore;

    private int nrOfTurns;

    // ------ CONSTRUCTORS

    public ScoreCardDto(int[] playerOneScore, int[] playerTwoScore, int nrOfTurns) {
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
        this.nrOfTurns = nrOfTurns;
    }

    public ScoreCardDto() {
    }

    // ------ GETTERS

    public int[] getPlayerOneScore() {
        return playerOneScore;
    }

    public int[] getPlayerTwoScore() {
        return playerTwoScore;
    }

    public int getNrOfTurns() {
        return nrOfTurns;
    }


    // ------ SETTERS

    public void setPlayerOneScore(int[] playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public void setPlayerTwoScore(int[] playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }

    public void setNrOfTurns(int nrOfTurns) {
        this.nrOfTurns = nrOfTurns;
    }

}
