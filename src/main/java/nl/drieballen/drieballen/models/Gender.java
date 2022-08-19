package nl.drieballen.drieballen.models;

public enum Gender {
    Male("Man"),
    FEMALE("Vrouw");

    private String string;

    Gender(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

}
