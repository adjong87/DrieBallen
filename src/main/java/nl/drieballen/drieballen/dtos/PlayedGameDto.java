package nl.drieballen.drieballen.dtos;
import lombok.Getter;
import lombok.Setter;
import nl.drieballen.drieballen.models.Profile;
import nl.drieballen.drieballen.models.ScoreCard;

@Getter
@Setter
public class PlayedGameDto {

    private ScoreCard scoreCard;
    private Profile profile;
    private boolean uitgespeeld;
}
