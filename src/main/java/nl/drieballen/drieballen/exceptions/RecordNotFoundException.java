package nl.drieballen.drieballen.exceptions;
import lombok.AllArgsConstructor;

import java.io.Serial;

@AllArgsConstructor
public class RecordNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(String message) {
        super(message);
    }
}
