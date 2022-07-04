package nl.drieballen.drieballen.dtos;

import nl.drieballen.drieballen.models.ScoreCard;


public class PlayedGameDto {

    private ScoreCard scoreCard;

    private boolean uitgespeeld;

    public ScoreCard getScoreCard() {
        return scoreCard;
    }

    public boolean isUitgespeeld() {
        return uitgespeeld;
    }

    public void setScoreCard(ScoreCard scoreCard) {
        this.scoreCard = scoreCard;
    }

    public void setUitgespeeld(boolean uitgespeeld) {
        this.uitgespeeld = uitgespeeld;
    }
}
