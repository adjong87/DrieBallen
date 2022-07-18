package nl.drieballen.drieballen.services;

import nl.drieballen.drieballen.models.Profile;
import nl.drieballen.drieballen.repositories.ProfileRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProfileServiceTest {

    @InjectMocks
    ProfileService profileService;

    @Mock
    ProfileRepository profileRepository;

    @BeforeEach
    void setUp() {
        List<Profile> profiles = Arrays.asList(
                new Profile("test", "test", "test", 66, 66)
        );
        profileRepository.saveAll(profiles);
    }

    @AfterEach
    void tearDown() {
        profileRepository.deleteAll();
    }

    @Test
    void getAllProfiles() {
    }

    @Test
    void getProfile() {
    }

    @Test
    void getUserData() {
    }

    @Test
    void fromProfile() {
    }

    @Test
    void fromUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void assignPhotoToProfile() {
    }
}