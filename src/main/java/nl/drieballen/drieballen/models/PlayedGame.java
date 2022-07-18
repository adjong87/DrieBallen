package nl.drieballen.drieballen.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
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
}
