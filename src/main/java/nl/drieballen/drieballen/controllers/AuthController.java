package nl.drieballen.drieballen.controllers;

import nl.drieballen.drieballen.models.ERole;
import nl.drieballen.drieballen.models.Profile;
import nl.drieballen.drieballen.models.Role;
import nl.drieballen.drieballen.models.User;
import nl.drieballen.drieballen.payload.request.LoginRequest;
import nl.drieballen.drieballen.payload.request.SignupRequest;
import nl.drieballen.drieballen.payload.response.JwtResponse;
import nl.drieballen.drieballen.payload.response.MessageResponse;
import nl.drieballen.drieballen.repositories.ProfileRepository;
import nl.drieballen.drieballen.repositories.RoleRepository;
import nl.drieballen.drieballen.repositories.UserRepository;
import nl.drieballen.drieballen.security.jwt.JwtUtils;
import nl.drieballen.drieballen.security.services.UserDetailsImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signIn")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        String jwt = jwtUtils.generateJwtToken(roles, userDetails);
        return ResponseEntity.ok(
                new JwtResponse(
                        jwt,
                        userDetails.getUsername(),
                        roles));
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(
                            new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(
                            new MessageResponse("Error: Email is already in use!"));
        }
        User user = new User(SignupRequest signUpRequest);

        Set<String> strAuthorities = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        strAuthorities.forEach(authority -> {
            switch (authority) {
                case "ADMIN" -> roles.add(roleRepository.getByName(ERole.ROLE_ADMIN));
                case "MODERATOR" -> roles.add(roleRepository.getByName(ERole.ROLE_MODERATOR));
                case "USER" -> roles.add(roleRepository.getByName(ERole.ROLE_USER));
            }
        });
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }


}