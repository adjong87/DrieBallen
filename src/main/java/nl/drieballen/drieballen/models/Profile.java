package nl.drieballen.drieballen.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import javax.persistence.*;

@Entity
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

    public Profile() {
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getAimScore() {
        return aimScore;
    }

    public PhotoUploadResponse getPhoto() {
        return photo;
    }

    @OneToMany
    public Collection<PlayedGame> getPlayedGames() {
        return playedGames;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAimScore(int aimScore) {
        this.aimScore = aimScore;
    }

    public void setPhoto(PhotoUploadResponse photo) {
        this.photo = photo;
    }

    public void setPlayedGames(Collection<PlayedGame> playedGames) {
        this.playedGames = playedGames;
    }

    public void addPlayedGame(PlayedGame playedGame){
        playedGames.add(playedGame);
    }

}

