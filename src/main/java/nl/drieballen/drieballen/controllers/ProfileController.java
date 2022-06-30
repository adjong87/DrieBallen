package nl.drieballen.drieballen.controllers;

import nl.drieballen.drieballen.dtos.ProfileDto;
import nl.drieballen.drieballen.dtos.ProfileInputDto;
import nl.drieballen.drieballen.models.User;
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

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User>userList;
        userList = profileService.getAllUsers();
        return ResponseEntity.ok().body(userList);
    }


    @GetMapping("/all")
    public ResponseEntity<List<ProfileDto>> getAllProfiles(){
        List<ProfileDto> profileDtoList;
        profileDtoList = profileService.getAllProfiles();
        return ResponseEntity.ok().body(profileDtoList);
    }

    @GetMapping(value = "/profile")
    public ResponseEntity<ProfileDto> getProfile(@RequestParam("username") String username) {
        ProfileDto optionalProfile = profileService.getProfile(username);
        return ResponseEntity.ok().body(optionalProfile);
    }

    @PutMapping(value="/change")
    public ProfileDto addProfile(@RequestBody ProfileInputDto profileInputDto){
        return profileService.changeProfile(profileInputDto);
    }

    @DeleteMapping(value = "/delete/{username}")
    public String deleteProfile(@PathVariable("username") String username) {
        profileService.deleteProfile(username);
        return "Gebruiker " + username + " is verwijderd";
    }
}
