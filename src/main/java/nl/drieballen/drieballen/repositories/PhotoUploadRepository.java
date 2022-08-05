package nl.drieballen.drieballen.repositories;

import nl.drieballen.drieballen.models.PhotoUploadResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PhotoUploadRepository extends JpaRepository<PhotoUploadResponse, String> {

    Optional<PhotoUploadResponse> findByFileName(String fileName);
}
