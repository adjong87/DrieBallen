package nl.drieballen.drieballen.dtos;


import nl.drieballen.drieballen.models.Gender;
import nl.drieballen.drieballen.models.PhotoUploadResponse;
import nl.drieballen.drieballen.models.PlayedGame;

import java.util.Collection;

public class ProfileDto {

    private String username;

    private String firstName;

    private String lastName;

    private int age;

    private String gender;

    private int aimScore;

    private PhotoUploadResponse photo;

    private Collection<PlayedGame> playedGames;

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

    public String getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = String.valueOf(gender);
    }
}



