package nl.drieballen.drieballen.controllers;

import nl.drieballen.drieballen.dtos.ProfileDto;
import nl.drieballen.drieballen.dtos.ProfileInputDto;
import nl.drieballen.drieballen.dtos.UserDto;
import nl.drieballen.drieballen.models.PhotoUploadResponse;
import nl.drieballen.drieballen.models.User;
import nl.drieballen.drieballen.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/profiles")
public class ProfileController {

    private final ProfileService profileService;

    private final PhotoController photoController;

    @Autowired
    public ProfileController(ProfileService profileService, PhotoController photoController) {
        this.profileService = profileService;
        this.photoController = photoController;
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

    @PutMapping(value="/change")
    public ProfileDto addProfile(@RequestBody ProfileInputDto profileInputDto){
        return profileService.changeProfile(profileInputDto);
    }

    @PostMapping("/{username}/photo")
    public void assignPhotoToProfile(@PathVariable("username") String username, @RequestBody MultipartFile file){
        PhotoUploadResponse photo = photoController.singleFileUpload(file);
        profileService.assignPhotoToProfile(photo.getFileName(), username);
    }

    @DeleteMapping(value = "/delete/{username}")
    public String deleteProfile(@PathVariable("username") String username) {
        profileService.deleteProfile(username);
        return "Gebruiker " + username + " is verwijderd";
    }


}
