package nl.drieballen.drieballen.dtos;

public class ProfileInputDto {

    private String firstName;

    private String lastName;

    private int age;

    private int aimScore;

    // ----- GETTERS ------------

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

    // ----- SETTERS ------------

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
}
