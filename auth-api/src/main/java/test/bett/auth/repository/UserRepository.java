package test.bett.auth.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import test.bett.auth.domain.model.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT u FROM User AS u WHERE u.email = :email")
    Optional<User> findByEmail(String email);

}
