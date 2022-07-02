package nl.drieballen.drieballen.dtos;

import javax.persistence.ElementCollection;
import java.util.List;

public class ScoreCardInputDto {

    @ElementCollection
    private List<Integer> playerOneScore;
    @ElementCollection
    private List<Integer> playerTwoScore;
    private boolean filledIn;

    public ScoreCardInputDto(List<Integer> playerOneScore, List<Integer> playerTwoScore) {
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
    }

    public List<Integer> getPlayerOneScore() {
        return playerOneScore;
    }

    public List<Integer> getPlayerTwoScore() {
        return playerTwoScore;
    }

    public void setPlayerOneScore(List<Integer> playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public void setPlayerTwoScore(List<Integer> playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }

    public boolean isFilledIn() {
        return filledIn;
    }
}

