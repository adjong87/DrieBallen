package nl.drieballen.drieballen.dtos;

public class ScoreCardInputDto {

    public int highestSerieP1;

    public int highestSerieP2;

    private int remainderP1;

    private int remainderP2;

    private double averageP1;

    private double averageP2;

    private int nrOfTurns;

    public int getHighestSerieP1() {
        return highestSerieP1;
    }

    public int getHighestSerieP2() {
        return highestSerieP2;
    }

    public int getRemainderP1() {
        return remainderP1;
    }

    public int getRemainderP2() {
        return remainderP2;
    }

    public double getAverageP1() {
        return averageP1;
    }

    public double getAverageP2() {
        return averageP2;
    }

    public int getNrOfTurns() {
        return nrOfTurns;
    }

    public void setHighestSerieP1(int highestSerieP1) {
        this.highestSerieP1 = highestSerieP1;
    }

    public void setHighestSerieP2(int highestSerieP2) {
        this.highestSerieP2 = highestSerieP2;
    }

    public void setRemainderP1(int remainderP1) {
        this.remainderP1 = remainderP1;
    }

    public void setRemainderP2(int remainderP2) {
        this.remainderP2 = remainderP2;
    }

    public void setAverageP1(double averageP1) {
        this.averageP1 = averageP1;
    }

    public void setAverageP2(double averageP2) {
        this.averageP2 = averageP2;
    }

    public void setNrOfTurns(int nrOfTurns) {
        this.nrOfTurns = nrOfTurns;
    }
}

