package nl.drieballen.drieballen.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import nl.drieballen.drieballen.dtos.ProfileDto;
import nl.drieballen.drieballen.exceptions.RecordNotFoundException;
import nl.drieballen.drieballen.models.PhotoUploadResponse;
import nl.drieballen.drieballen.models.Profile;
import nl.drieballen.drieballen.repositories.PhotoUploadRepository;
import nl.drieballen.drieballen.repositories.ProfileRepository;
import nl.drieballen.drieballen.repositories.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProfileService {

    private final ProfileRepository profileRepository;

    private final UserRepository userRepository;

    private final PhotoUploadRepository photoUploadRepository;

    public ProfileService(ProfileRepository profileRepository, UserRepository userRepository, PhotoUploadRepository photoUploadRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.photoUploadRepository = photoUploadRepository;
    }

    public List<ProfileDto> getAllProfiles() {
        List<ProfileDto> profileDtoList = new ArrayList<>();
        List<Profile> profileList = profileRepository.findAll();
        for (Profile profile : profileList) {
            profileDtoList.add(fromProfile(profile));
        }
        return profileDtoList;
    }

    public ProfileDto getProfile(String username) {
        Profile profile = profileRepository.findByUsername(username).orElseThrow(() ->
                new RuntimeException("Profiel niet gevonden"));
        return fromProfile(profile);
    }

    public static ProfileDto fromProfile(Profile profile) {
        var dto = new ProfileDto();
        dto.setUsername(profile.getUsername());
        dto.setFirstName(profile.getFirstName());
        dto.setLastName(profile.getLastName());
        dto.setAge(profile.getAge());
        dto.setAimScore(profile.getAimScore());
        dto.setPhoto(profile.getPhoto());
        dto.setPlayedGames(profile.getPlayedGames());
        return dto;
    }

    public void deleteUser(String username) {
        if(userRepository.existsByUsername(username)) {
            userRepository.deleteByUsername(username);
            profileRepository.deleteByUsername(username);
        } else {
            throw new UsernameNotFoundException("Gebruikersnaam bestaat niet");
        }
    }

    public void assignPhotoToProfile(String fileName, String username) {
        Optional<Profile> optionalProfile = profileRepository.findByUsername(username);
        Optional<PhotoUploadResponse> photoUploadResponse = photoUploadRepository.findByFileName(fileName);
        if (optionalProfile.isPresent() && photoUploadResponse.isPresent()) {
            PhotoUploadResponse photo = photoUploadResponse.get();
            Profile profile = optionalProfile.get();
            profile.setPhoto(photo);
            profileRepository.save(profile);
        } else {
            throw new RecordNotFoundException("Het profiel kan niet worden gevonden");
        }
    }
}