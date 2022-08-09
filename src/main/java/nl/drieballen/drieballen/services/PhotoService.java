package nl.drieballen.drieballen.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.Optional;

import nl.drieballen.drieballen.models.PhotoUploadResponse;
import nl.drieballen.drieballen.models.Profile;
import nl.drieballen.drieballen.repositories.PhotoUploadRepository;
import nl.drieballen.drieballen.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PhotoService {
    @Value("${my.upload_location}")
    private Path fileStoragePath;
    private final String fileStorageLocation;
    private final PhotoUploadRepository photoUploadRepository;

    private final ProfileRepository profileRepository;

    public PhotoService(@Value("${my.upload_location}") String fileStorageLocation,
                        PhotoUploadRepository photoUploadRepository,
                        ProfileRepository profileRepository) {
        fileStoragePath = Paths.get(fileStorageLocation).toAbsolutePath().normalize();
        this.fileStorageLocation = fileStorageLocation;
        this.photoUploadRepository = photoUploadRepository;
        this.profileRepository = profileRepository;

        try {
            Files.createDirectories(fileStoragePath);
        } catch (IOException e) {
            throw new RuntimeException("Issue in creating file directory");
        }
    }

    public PhotoUploadResponse uploadPhoto(MultipartFile file, String url) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Path filePath = Paths.get(fileStoragePath + "\\" + fileName);
        // change for windows to two backslashes: "\\" + fileName. For mac it's "/".
        try {
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Issue in storing the file", e);
        }
        PhotoUploadResponse photo = new PhotoUploadResponse(fileName, file.getContentType(), url);
        photoUploadRepository.save(photo);
        return photo;
    }

    public Resource downLoadFile(String fileName) {
        Path path = Paths.get(fileStorageLocation).toAbsolutePath().resolve(fileName);
        Resource resource;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Issue in reading the file", e);
        }
        if(resource.exists()&& resource.isReadable()) {
            return resource;
        } else {
            throw new RuntimeException("the file doesn't exist or not readable");
        }
    }

    public String deletePhoto(String username) {
        Optional<Profile> profile = profileRepository.findByUsername(username);
        String filename = profile.get().getPhoto().getFileName();
        profile.get().setPhoto(null);
        photoUploadRepository.deleteById(filename);
        profileRepository.save(profile.get());
        return filename;
    }
}



