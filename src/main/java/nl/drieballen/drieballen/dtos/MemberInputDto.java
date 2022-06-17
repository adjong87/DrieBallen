package nl.drieballen.drieballen.dtos;

public class MemberInputDto {

    private String username;

    private String password;

    private int doB;

    private String firstName;

    private String lastName;

    private String email;

    private int age;

    private char gender;

    private int aimScore;

    // ----- GETTERS ------------

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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

    public int getDoB() {
        return doB;
    }

    public char getGender() {
        return gender;
    }

    public int getAimScore() {
        return aimScore;
    }

    // ----- SETTERS ------------


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setDoB(int doB) {
        this.doB = doB;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAimScore(int aimScore) {
        this.aimScore = aimScore;
    }
}
