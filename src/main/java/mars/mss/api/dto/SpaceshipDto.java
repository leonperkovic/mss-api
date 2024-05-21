package mars.mss.api.dto;

import mars.mss.api.model.Spaceship;

import java.util.UUID;

public class SpaceshipDto {
    private UUID id;
    private String name;
    private Integer supportedCrew;
    private Integer cargoLimit;
    private boolean available;

    public static SpaceshipDto fromModel(Spaceship spaceship) {
        var shipDto = new SpaceshipDto();
        shipDto.id = spaceship.getId();
        shipDto.name = spaceship.getName();
        shipDto.supportedCrew = spaceship.getSupportedCrew();
        shipDto.cargoLimit = spaceship.getCargoLimit();
        shipDto.available = spaceship.isAvailable();
        return shipDto;
    }

    public Spaceship toModel() {
        return new Spaceship(id, name, supportedCrew, cargoLimit, available);
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
        return "SpaceshipDto{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", supportedCrew=" + supportedCrew +
               ", cargoLimit=" + cargoLimit +
               ", available=" + available +
               '}';
    }
}
