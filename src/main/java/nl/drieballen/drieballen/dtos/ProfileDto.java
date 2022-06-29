package nl.drieballen.drieballen.dtos;
import nl.drieballen.drieballen.models.PlayedGame;
import java.util.Collection;


public class ProfileDto {
    private String username;
    private String firstName;

    private String lastName;

    private String email;

    private int age;

    private char gender;

    private int aimScore;

    private Collection<PlayedGame> playedGames;


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

}



