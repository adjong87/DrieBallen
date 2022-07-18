package nl.drieballen.drieballen.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ScoreCard {

    public ScoreCard(String playerOneName, String playerTwoName, int aimScoreP1, int aimScoreP2) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.aimScoreP1 = aimScoreP1;
        this.aimScoreP2 = aimScoreP2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String playerOneName;

    private String playerTwoName;

    public int highestSerieP1;

    public int highestSerieP2;

    private int aimScoreP1;

    private int aimScoreP2;

    private int remainderP1;

    private int remainderP2;

    private double averageP1;

    private double averageP2;

    private int nrOfTurns;

    private LocalDate gespeeldOp = LocalDate.now();

    @JsonIgnore
    @OneToMany(mappedBy = "scoreCard", cascade = CascadeType.ALL)
    private Collection<PlayedGame> playedGames;

    private boolean filledIn;
    public void addPlayedGame(PlayedGame playedGame){
        playedGames.add(playedGame);
    }

}
