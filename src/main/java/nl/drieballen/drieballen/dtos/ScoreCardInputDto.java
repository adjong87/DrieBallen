package nl.drieballen.drieballen.dtos;

import javax.persistence.ElementCollection;
import java.util.List;

public class ScoreCardInputDto {

    private int[] playerOneScore;

    private int[] playerTwoScore;

    private int remainderP1;

    private int remainderP2;

    public ScoreCardInputDto(int[] playerOneScore, int[] playerTwoScore, int remainderP1, int remainderP2) {
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
        this.remainderP1 = remainderP1;
        this.remainderP2 = remainderP2;
    }

    public int[] getPlayerOneScore() {
        return playerOneScore;
    }

    public int[] getPlayerTwoScore() {
        return playerTwoScore;
    }

    public int getRemainderP1() {
        return remainderP1;
    }

    public int getRemainderP2() {
        return remainderP2;
    }

    public void setPlayerOneScore(int[] playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public void setPlayerTwoScore(int[] playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }

    public void setRemainderP1(int remainderP1) {
        this.remainderP1 = remainderP1;
    }

    public void setRemainderP2(int remainderP2) {
        this.remainderP2 = remainderP2;
    }
}

