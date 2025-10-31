package test.bett.auth.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import test.bett.auth.domain.model.entity.ProcessingLog;

public interface ProcessingLogRepository extends JpaRepository<ProcessingLog, UUID> {
}