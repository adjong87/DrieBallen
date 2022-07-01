package nl.drieballen.drieballen.models;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class PlayedGame {

    @EmbeddedId
    PlayedGameId id;

    @ManyToOne
    @MapsId("profileUsername")
    @JoinColumn(name = "profile_username")
    Profile profile;

    @ManyToOne
    @MapsId(value = "scoreCardId")
    @JoinColumn(name = "scorecard_id")
    ScoreCard scoreCard;

    boolean uitgespeeld;

    public PlayedGame() {
    }

    public PlayedGame(PlayedGameId id, Profile profile, ScoreCard scoreCard) {
        this.id = id;
        this.profile = profile;
        this.scoreCard = scoreCard;
    }

//    public void determineWin() {
//        if (profile.getFirstName() == scoreCard.getPlayerOneName()) {
//            if (Arrays.stream(scoreCard.getPlayerOneScore()).sum() > profile.getAimScore()) {
//                uitgespeeld = true;
//            } else uitgespeeld = false;
//        }
//        {
//            if (Arrays.stream(scoreCard.getPlayerTwoScore()).sum() > profile.getAimScore()) {
//                uitgespeeld = true;
//            }
//            else uitgespeeld = false;
//        }
//    }


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
