package nl.drieballen.drieballen.models;

import javax.persistence.*;
import java.time.LocalDateTime;

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




}
