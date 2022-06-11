package nl.drieballen.drieballen.dtos;

import java.time.LocalDateTime;

public class MemberDto {

    private String username;
    private int doB;

    private String firstName;

    private String lastName;

    private int aimScore;
    private LocalDateTime gameStartedAt;

    // ----- GETTERS ------------


    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getDoB() {
        return doB;
    }

    public int getAimScore() {
        return aimScore;
    }

    public LocalDateTime gameStartedAt() {
        return gameStartedAt;
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

    public void setDoB(int doB) {
        this.doB = doB;
    }

    public void setAimScore(int aimScore) {
        this.aimScore = aimScore;
    }
}


