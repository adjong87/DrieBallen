package nl.drieballen.drieballen.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.Period;
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

    private int aimScore;

    @OneToOne
    private PhotoUploadResponse photo;

    @JsonIgnore
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private Collection<PlayedGame> playedGames;

    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int age;

    public Profile(String username,
                   String firstName,
                   String lastName,
                   LocalDate dob,
                   int aimScore, Gender gender) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.aimScore = aimScore;
        this.age = Period.between(dob, LocalDate.now()).getYears();
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
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

    public void addPlayedGame(PlayedGame playedGame) {
        playedGames.add(playedGame);
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

