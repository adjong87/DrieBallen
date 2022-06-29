package nl.drieballen.drieballen.services;

import nl.drieballen.drieballen.dtos.ProfileDto;
import nl.drieballen.drieballen.dtos.ProfileInputDto;
import nl.drieballen.drieballen.models.Profile;
import nl.drieballen.drieballen.models.User;
import nl.drieballen.drieballen.repositories.ProfileRepository;
import nl.drieballen.drieballen.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProfileService {

    private final ProfileRepository profileRepository;

    private final UserRepository userRepository;

    public ProfileService(ProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        List<User>userList = userRepository.findAll();
        return userList;
    }

    public List<ProfileDto> getAllProfiles(){
        List<ProfileDto> profileDtoList = new ArrayList<>();
        List<Profile> profileList = profileRepository.findAll();
        for(Profile profile : profileList){
            profileDtoList.add(fromProfile(profile));
        }
        return profileDtoList;
    }

    public ProfileDto getProfile(String username) {
        ProfileDto dto = new ProfileDto();
        Profile profile = profileRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("test"));
         return dto = fromProfile(profile);
    }

    public ProfileDto changeProfile(ProfileInputDto profileInputDto) {
        Profile profile = toProfile(profileInputDto);
        profileRepository.save(profile);
        return fromProfile(profile);
    }

    private static Profile toProfile(ProfileInputDto profileInputDto) {
        var profile = new Profile();
        profile.setUsername(profileInputDto.getUsername());
        profile.setFirstName(profileInputDto.getFirstName());
        profile.setLastName(profileInputDto.getLastName());
        profile.setEmail(profileInputDto.getEmail());
        profile.setAge(profileInputDto.getAge());
        profile.setGender(profileInputDto.getGender());
        profile.setAimScore(profileInputDto.getAimScore());
        return profile;
    }

    public static ProfileDto fromProfile(Profile profile) {
        var dto = new ProfileDto();
        dto.setUsername(profile.getUsername());
        dto.setFirstName(profile.getFirstName());
        dto.setLastName(profile.getLastName());
        dto.setEmail(profile.getEmail());
        dto.setAge(profile.getAge());
        dto.setGender(profile.getGender());
        dto.setAimScore(profile.getAimScore());
        dto.setPlayedGames(profile.getPlayedGames());
        return dto;
    }

    public void deleteProfile(String username) {
        profileRepository.deleteByUsername(username);
    }
}