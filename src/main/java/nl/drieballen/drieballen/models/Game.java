package nl.drieballen.drieballen.models;

public class Game {

    private Member player1;

    private Member player2;

    private int[] player1Score;

    private int[] player2Score;

    private String billiard;

    private int nrOfTurns;

//    private Date date;

    // ----- GETTERS ------------

    public Member getPlayer1() {
        return player1;
    }

    public Member getPlayer2() {
        return player2;
    }

    public int[] getPlayer1Score() {
        return player1Score;
    }

    public int[] getPlayer2Score() {
        return player2Score;
    }

    public String getBilliard() {
        return billiard;
    }

    public int getNrOfTurns() {
        return nrOfTurns;
    }

    // ----- SETTERS ------------


    public void setPlayer1(Member player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Member player2) {
        this.player2 = player2;
    }

    public void setPlayer1Score(int[] player1Score) {
        this.player1Score = player1Score;
    }

    public void setPlayer2Score(int[] player2Score) {
        this.player2Score = player2Score;
    }

    public void setBilliard(String billiard) {
        this.billiard = billiard;
    }

    public void setNrOfTurns(int nrOfTurns) {
        this.nrOfTurns = nrOfTurns;
    }
}
