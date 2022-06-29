package nl.drieballen.drieballen.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PlayedGameId implements Serializable {

    @Column(name = "profile_username")
    String username;

    @Column(name = "scorecard_id")
    Long id;

    public PlayedGameId(String username, Long id) {
        this.username = username;
        this.id = id;
    }

    public PlayedGameId() {
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
