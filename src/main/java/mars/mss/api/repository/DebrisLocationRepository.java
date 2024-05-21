package mars.mss.api.repository;

import mars.mss.api.model.DebrisLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DebrisLocationRepository extends JpaRepository<DebrisLocation, UUID> {
    List<DebrisLocation> findAllByCleared(boolean cleared);

    @Modifying
    @Query("update DebrisLocation dl set dl.cleared = true where dl.id = ?1")
    void markAsCleared(UUID id);
}
