package nl.drieballen.drieballen.controllers;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;

import nl.drieballen.drieballen.models.PhotoUploadResponse;
import nl.drieballen.drieballen.services.PhotoService;
import nl.drieballen.drieballen.services.ProfileService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin
@RequestMapping(value = "")
public class PhotoController {

    private final PhotoService photoservice;

    private final ProfileService profileService;

    public PhotoController(PhotoService photoservice, ProfileService profileService) {
        this.photoservice = photoservice;
        this.profileService = profileService;
    }

    @PostMapping("/upload/{username}/photo")
    public ResponseEntity<String> uploadPhoto(@PathVariable("username") String username,
                                              @RequestBody MultipartFile file) {
        String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/")
                .path(Objects.requireNonNull(file.getOriginalFilename())).toUriString();
        PhotoUploadResponse photo = photoservice.uploadPhoto(file, url);
        profileService.assignPhotoToProfile(photo.getFileName(), username);
        return ResponseEntity.ok("Foto is succesvol geupload");
    }

    @GetMapping("/download/{fileName}")
    ResponseEntity<Resource> downloadPhoto(@PathVariable String fileName, HttpServletRequest request) {
        Resource resource = photoservice.downLoadFile(fileName);
        String mimeType;
        try {
            mimeType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(mimeType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline;fileName=" + resource.getFilename()).body(resource);
    }

    @DeleteMapping(value = "/delete/{username}/photo")
    public ResponseEntity<String> deletePhoto(@PathVariable("username") String username) {
        photoservice.deletePhoto(username);
        return ResponseEntity.ok(photoservice.deletePhoto(username));
    }
}