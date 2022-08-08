package nl.drieballen.drieballen.repositories;

import java.util.Optional;
import nl.drieballen.drieballen.models.PhotoUploadResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoUploadRepository extends JpaRepository<PhotoUploadResponse, String> {

    Optional<PhotoUploadResponse> findByFileName(String fileName);
}
