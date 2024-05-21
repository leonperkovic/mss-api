package mars.mss.api.repository;

import mars.mss.api.model.Spaceship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SpaceshipRepository extends JpaRepository<Spaceship, UUID> {
    List<Spaceship> findAllByAvailable(boolean available);

    @Modifying
    @Query("update Spaceship s set s.available = true where s.id = ?1")
    void markAsAvailable(UUID id);

    @Modifying
    @Query("update Spaceship s set s.available = false where s.id = ?1")
    void markAsUnavailable(UUID id);
}
