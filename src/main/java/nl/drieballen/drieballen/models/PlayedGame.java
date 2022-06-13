package nl.drieballen.drieballen.models;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    public PlayedGame(PlayedGameId id, Member member, ScoreCard scoreCard, boolean uitgespeeld) {
        this.id = id;
        this.member = member;
        this.scoreCard = scoreCard;
        this.uitgespeeld = uitgespeeld;
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

    public boolean setUitgespeeld() {
        if (Arrays.stream(scoreCard.getPlayerOneScore()).count() >= member.getAimScore()) {
            return true;
        }
        else return false;
    }
}
