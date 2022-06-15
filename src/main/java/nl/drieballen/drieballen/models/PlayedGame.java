package nl.drieballen.drieballen.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class PlayedGame {

    @EmbeddedId
    PlayedGameId id;

    @ManyToOne
    @JsonIgnore
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
