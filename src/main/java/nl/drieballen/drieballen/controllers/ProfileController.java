package nl.drieballen.drieballen.controllers;

import java.util.List;
import nl.drieballen.drieballen.dtos.ProfileDto;
import nl.drieballen.drieballen.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/profiles")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProfileDto>> getAllProfiles() {
        List<ProfileDto> profileDtoList;
        profileDtoList = profileService.getAllProfiles();
        return ResponseEntity.ok().body(profileDtoList);
    }

    @GetMapping(value = "/profile")
    public ResponseEntity<ProfileDto> getProfile(@RequestParam("username") String username) {
        ProfileDto optionalProfile = profileService.getProfile(username);
        if(optionalProfile != null) {
            return ResponseEntity.ok().body(optionalProfile);

        } else {
            throw new UsernameNotFoundException("Gebruiker met gebruikersnaam " + username + " niet gevonden");
        }
    }

    @DeleteMapping(value = "/delete/{username}")
    public ResponseEntity<String> deleteProfile(@PathVariable("username") String username) {
        profileService.deleteUser(username);
        return ResponseEntity.ok("Gebruiker " + username + " is verwijderd");
    }


}
