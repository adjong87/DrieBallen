package nl.drieballen.drieballen.dtos;
import lombok.Getter;
import lombok.Setter;
import nl.drieballen.drieballen.models.PhotoUploadResponse;
import nl.drieballen.drieballen.models.PlayedGame;
import java.util.Collection;

@Getter
@Setter
public class ProfileDto {

    private String username;
    private String firstName;
    private String lastName;
    private int age;
    private int aimScore;
    private PhotoUploadResponse photo;
    private Collection<PlayedGame> playedGames;
}



