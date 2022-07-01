package nl.drieballen.drieballen.dtos;

import nl.drieballen.drieballen.models.Role;

import java.util.HashSet;
import java.util.Set;

public class UserDto {

    private String username;
    private Set<Role> roles = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
