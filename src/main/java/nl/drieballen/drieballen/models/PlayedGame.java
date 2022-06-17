package nl.drieballen.drieballen.models;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class PlayedGame {

    @EmbeddedId
    PlayedGameId id;

    @ManyToOne
    @MapsId("memberUsername")
    @JoinColumn(name = "member_username")
    Member member;

    @ManyToOne
    @MapsId(value = "scoreCardId")
    @JoinColumn(name = "scorecard_id")
    ScoreCard scoreCard;

    boolean uitgespeeld;

    public PlayedGame() {
    }

    public PlayedGame(PlayedGameId id, Member member, ScoreCard scoreCard) {
        this.id = id;
        this.member = member;
        this.scoreCard = scoreCard;
    }

    public PlayedGame(Member member, ScoreCard scoreCard) {
        this.member = member;
        this.scoreCard = scoreCard;
    }

    public void determineWin() {
        if (member.getFirstName() == scoreCard.getPlayerOneName()) {
            if (Arrays.stream(scoreCard.getPlayerOneScore()).sum() > member.getAimScore()) {
                uitgespeeld = true;
            } else uitgespeeld = false;
        }
        {
            if (Arrays.stream(scoreCard.getPlayerTwoScore()).sum() > member.getAimScore()) {
                uitgespeeld = true;
            }
            else uitgespeeld = false;
        }
    }


    public PlayedGameId getId() {
        return id;
    }

    public Member getMember() {
        return member;
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

    public void setMember(Member member) {
        this.member = member;
    }

    public void setScoreCard(ScoreCard scoreCard) {
        this.scoreCard = scoreCard;
    }

    public void setUitgespeeld(boolean uitgespeeld) {
        this.uitgespeeld = uitgespeeld;
    }

}
        }