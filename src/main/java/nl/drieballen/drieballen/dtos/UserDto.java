package nl.drieballen.drieballen.dtos;
import lombok.Getter;
import lombok.Setter;
import nl.drieballen.drieballen.models.Role;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserDto {
    private String username;
    private Set<Role> roles = new HashSet<>();
}
