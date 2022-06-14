package nl.drieballen.drieballen.dtos;

public class ScoreCardDto {

    private Long Id;

    private String playerOneName;

    private String playerTwoName;

    private int[] playerOneScore;

    private int[] playerTwoScore;

    private int nrOfTurns;

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

    public int getNrOfTurns() {
        return nrOfTurns;
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

    public void setNrOfTurns(int nrOfTurns) {
        this.nrOfTurns = nrOfTurns;
    }

}
