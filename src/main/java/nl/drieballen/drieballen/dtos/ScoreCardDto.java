package nl.drieballen.drieballen.dtos;

public class ScoreCardDto {

    private Long Id;
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

    public Long getId() {
        return Id;
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


    // ------ SETTERS


    public void setId(Long id) {
        Id = id;
    }

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
