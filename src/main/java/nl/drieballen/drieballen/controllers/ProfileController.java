package nl.drieballen.drieballen.controllers;
import nl.drieballen.drieballen.dtos.ProfileDto;
import nl.drieballen.drieballen.dtos.UserDto;
import nl.drieballen.drieballen.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public ResponseEntity<List<ProfileDto>> getAllProfiles(){
        List<ProfileDto> profileDtoList;
        profileDtoList = profileService.getAllProfiles();
        return ResponseEntity.ok().body(profileDtoList);
    }

    @GetMapping("/getUserData/{username}")
    public ResponseEntity<UserDto> getUserData(@PathVariable(value = "username") String username){
        UserDto optionalUser = profileService.getUserData(username);
        return ResponseEntity.ok().body(optionalUser);
    }

    @GetMapping(value = "/profile")
    public ResponseEntity<ProfileDto> getProfile(@RequestParam("username") String username) {
        ProfileDto optionalProfile = profileService.getProfile(username);
        return ResponseEntity.ok().body(optionalProfile);
    }

    @DeleteMapping(value = "/delete/{username}")
    public String deleteProfile(@PathVariable("username") String username) {
        profileService.deleteUser(username);
        return "Gebruiker " + username + " is verwijderd";
    }


}
