package nl.drieballen.drieballen.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class PlayedGame {
    @JsonIgnore
    @EmbeddedId
    PlayedGameId id;

    @JsonIgnore
    @ManyToOne
    @MapsId("profileUsername")
    @JoinColumn(name = "profile_username")
    Profile profile;

    @ManyToOne
    @MapsId(value = "scoreCardId")
    @JoinColumn(name = "scorecard_id")
    ScoreCard scoreCard;

    boolean uitgespeeld;

    public PlayedGame(PlayedGameId id, Profile profile, ScoreCard scoreCard) {
        this.id = id;
        this.profile = profile;
        this.scoreCard = scoreCard;
    }

    public PlayedGame() {
    }

    public PlayedGameId getId() {
        return id;
    }

    public Profile getProfile() {
        return profile;
    }

    public ScoreCard getScoreCard() {
        return scoreCard;
    }

    public boolean isUitgespeeld() {
        return uitgespeeld;
    }

    public void setId(PlayedGameId id) {
        this.id = id;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setScoreCard(ScoreCard scoreCard) {
        this.scoreCard = scoreCard;
    }

    public void setUitgespeeld(boolean uitgespeeld) {
        this.uitgespeeld = uitgespeeld;
    }

}
