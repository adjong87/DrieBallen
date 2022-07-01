package nl.drieballen.drieballen.dtos;

public class ScoreCardInputDto {

    private int[] playerOneScore;

    private int[] playerTwoScore;
    private boolean filledIn;

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

    public boolean isFilledIn() {
        return filledIn;
    }
}

