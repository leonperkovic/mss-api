package mars.mss.api.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "spaceship")
public class Spaceship {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "supported_crew")
    private Integer supportedCrew;
    @Column(name = "cargo_limit")
    private Integer cargoLimit;
    @Column(name = "available")
    private boolean available = true;

    public Spaceship() {}

    public Spaceship(UUID id, String name, Integer supportedCrew, Integer cargoLimit, boolean available) {
        this.id = id;
        this.name = name;
        this.supportedCrew = supportedCrew;
        this.cargoLimit = cargoLimit;
        this.available = available;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSupportedCrew() {
        return supportedCrew;
    }

    public void setSupportedCrew(Integer supportedCrew) {
        this.supportedCrew = supportedCrew;
    }

    public Integer getCargoLimit() {
        return cargoLimit;
    }

    public void setCargoLimit(Integer cargoLimit) {
        this.cargoLimit = cargoLimit;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Spaceship{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", supportedCrew=" + supportedCrew +
               ", cargoLimit=" + cargoLimit +
               ", available=" + available +
               '}';
    }
}
