package nl.drieballen.drieballen.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayedGameId implements Serializable {

    @Column(name = "profile_username")
    String username;

    @Column(name = "scorecard_id")
    Long id;
}
