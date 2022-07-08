package nl.drieballen.drieballen.dtos;

import nl.drieballen.drieballen.models.Profile;
import nl.drieballen.drieballen.models.ScoreCard;


public class PlayedGameDto {

    private ScoreCard scoreCard;

    private Profile profile;

    private boolean uitgespeeld;

    public ScoreCard getScoreCard() {
        return scoreCard;
    }

    public Profile getProfile() {
        return profile;
    }

    public boolean isUitgespeeld() {
        return uitgespeeld;
    }

    public void setScoreCard(ScoreCard scoreCard) {
        this.scoreCard = scoreCard;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setUitgespeeld(boolean uitgespeeld) {
        this.uitgespeeld = uitgespeeld;
    }
}
