package nl.drieballen.drieballen.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.drieballen.drieballen.payload.request.SignupRequest;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })

public class User {
        @Id
        @NotBlank
        @Column(name = "username")
        @Size(max = 20)
        private String username;

        @NotBlank
        @Size(max = 50)
        @Email
        private String email;

        @NotBlank
        @Size(max = 120)
        private String password;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable( name = "user_roles",
                joinColumns = @JoinColumn(name = "user_username"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        private Set<Role> roles = new HashSet<>();

        @OneToOne
        @JoinColumn(name="user_profile")
        private Profile profile;

        public User (SignupRequest request) {
                username = request.getUsername();
                email = request.getEmail();
                password = request.getPassword();
                profile = new Profile(request.getUsername(), request.getFirstName(), request.getLastName(), request.getDob(), request.getAimScore()), request.getGender();
        }
        public User() {
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public Set<Role> getRoles() {
                return roles;
        }

        public void setRoles(Set<Role> roles) {
                this.roles = roles;
        }

        public Profile getProfile() {
                return profile;
        }

        public void setProfile(Profile profile) {
                this.profile = profile;
        }
}