package nl.drieballen.drieballen.services;

import nl.drieballen.drieballen.exceptions.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
