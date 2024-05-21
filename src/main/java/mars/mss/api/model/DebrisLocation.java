package mars.mss.api.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "debris_location")
public class DebrisLocation {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "estimated_size")
    private Integer estimatedSize;
    @Column(name = "cleared")
    private boolean cleared;

    public DebrisLocation() {}

    public DebrisLocation(UUID id, Integer estimatedSize, boolean cleared) {
        this.id = id;
        this.estimatedSize = estimatedSize;
        this.cleared = cleared;
    }

    @PrePersist
    public void onCreate() {
        if (id == null) id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getEstimatedSize() {
        return estimatedSize;
    }

    public void setEstimatedSize(Integer estimatedSize) {
        this.estimatedSize = estimatedSize;
    }

    public boolean isCleared() {
        return cleared;
    }

    public void setCleared(boolean cleared) {
        this.cleared = cleared;
    }

    @Override
    public String toString() {
        return "DebrisLocation{" +
               "id=" + id +
               ", estimatedSize=" + estimatedSize +
               ", cleared=" + cleared +
               '}';
    }
}
