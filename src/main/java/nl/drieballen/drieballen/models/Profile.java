package nl.drieballen.drieballen.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @Column(name = "username")
    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private int age;

    private char gender;

    private int aimScore;

    @JsonIgnore
    @OneToMany(mappedBy = "profile")
    private Collection<PlayedGame> playedGames;

    public Profile(String username, String firstName, String lastName, String email, int age, char gender, int aimScore) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.aimScore = aimScore;
    }

    public Profile() {
    }

    // ----- GETTERS ------------


    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public int getAimScore() {
        return aimScore;
    }

    @OneToMany
    public Collection<PlayedGame> getPlayedGames() {
        return playedGames;
    }

    // ----- SETTERS ------------


    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAimScore(int aimScore) {
        this.aimScore = aimScore;
    }

    public void setPlayedGames(Collection<PlayedGame> playedGames) {
        this.playedGames = playedGames;
    }

    public void addPlayedGame(PlayedGame playedGame){
        playedGames.add(playedGame);
    }

}

