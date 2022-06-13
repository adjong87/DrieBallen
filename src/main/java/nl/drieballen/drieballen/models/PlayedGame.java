package nl.drieballen.drieballen.models;

import javax.persistence.*;

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

    public void checkUitgespeeld() {
        int toGetScore = member.getAimScore();
        int totalPoints = 0;
        for (int i = 0; i < scoreCard.getPlayerOneScore().length; i++) {
            totalPoints += scoreCard.getPlayerOneScore()[i];
        }
        if (toGetScore <= totalPoints){
            uitgespeeld = true;
        } else { uitgespeeld = false;
        }
    }
}
