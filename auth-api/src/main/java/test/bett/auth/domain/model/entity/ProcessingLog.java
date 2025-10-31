package test.bett.auth.domain.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;


@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "processing_logs")
public class ProcessingLog {

    @Id
    UUID id;

    @Column(name = "user_id", nullable = false, updatable = false)
    UUID userId;

    @Column(name = "input_text", nullable = false, updatable = false)
    String inputText;

    @Column(name = "output_text", nullable = false, updatable = false)
    String outputText;

    @Column(name = "created_at", nullable = false, updatable = false)
    LocalDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        return (o instanceof ProcessingLog that) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
