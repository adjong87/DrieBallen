package nl.drieballen.drieballen.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "profiles")
public class Profile {

    @Id
    @Column(name = "username")
    private String username;

    private String firstName;

    private String lastName;

    private int age;

    private int aimScore;

    @OneToOne
    private PhotoUploadResponse photo;

    @JsonIgnore
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private Collection<PlayedGame> playedGames;

    public Profile(String username, String firstName, String lastName, int age, int aimScore) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.aimScore = aimScore;
    }

    public void addPlayedGame(PlayedGame playedGame){
        playedGames.add(playedGame);
    }
}

