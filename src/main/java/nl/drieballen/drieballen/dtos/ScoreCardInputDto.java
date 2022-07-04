package nl.drieballen.drieballen.dtos;

import javax.persistence.ElementCollection;
import java.util.List;

public class ScoreCardInputDto {

private int[] playerOneScore;

    private int[] playerTwoScore;

    public ScoreCardInputDto(int[] playerOneScore, int[] playerTwoScore) {
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
    }

    public int[] getPlayerOneScore() {
        return playerOneScore;
    }

    public int[] getPlayerTwoScore() {
        return playerTwoScore;
    }

    public void setPlayerOneScore(int[] playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public void setPlayerTwoScore(int[] playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }

}

