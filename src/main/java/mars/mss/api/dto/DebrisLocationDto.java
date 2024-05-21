package mars.mss.api.dto;

import mars.mss.api.model.DebrisLocation;

import java.util.UUID;

public class DebrisLocationDto {
    private UUID id;
    private Integer estimatedSize;
    private boolean cleared;

    public static DebrisLocationDto fromModel(DebrisLocation debrisLocation) {
        var dto = new DebrisLocationDto();
        dto.id = debrisLocation.getId();
        dto.estimatedSize = debrisLocation.getEstimatedSize();
        dto.cleared = debrisLocation.isCleared();
        return dto;
    }

    public DebrisLocation toModel() {
        return new DebrisLocation(id, estimatedSize, cleared);
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
        return "DebrisLocationDto{" +
               "id=" + id +
               ", estimatedSize=" + estimatedSize +
               ", cleared=" + cleared +
               '}';
    }
}
