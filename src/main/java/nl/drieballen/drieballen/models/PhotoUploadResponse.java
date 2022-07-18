package nl.drieballen.drieballen.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhotoUploadResponse {

    @Id
    private String fileName;

    private String contentType;

    private String url;
}
