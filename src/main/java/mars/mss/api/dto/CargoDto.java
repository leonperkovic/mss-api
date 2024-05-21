package mars.mss.api.dto;

import mars.mss.api.model.Cargo;

import java.util.UUID;

public class CargoDto {
    private UUID id;
    private Integer engineModules;
    private Integer powerCores;
    private Integer commArrays;
    private Integer hullPlatings;

    public static CargoDto fromModel(Cargo cargo) {
        var cargoDto = new CargoDto();
        cargoDto.id = cargo.getId();
        cargoDto.engineModules = cargo.getEngineModules();
        cargoDto.powerCores = cargo.getPowerCores();
        cargoDto.commArrays = cargo.getCommArrays();
        cargoDto.hullPlatings = cargo.getHullPlatings();
        return cargoDto;
    }

    public Cargo toModel() {
        return new Cargo(id, engineModules, powerCores, commArrays, hullPlatings);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getEngineModules() {
        return engineModules;
    }

    public void setEngineModules(Integer engineModules) {
        this.engineModules = engineModules;
    }

    public Integer getPowerCores() {
        return powerCores;
    }

    public void setPowerCores(Integer powerCores) {
        this.powerCores = powerCores;
    }

    public Integer getCommArrays() {
        return commArrays;
    }

    public void setCommArrays(Integer commArrays) {
        this.commArrays = commArrays;
    }

    public Integer getHullPlatings() {
        return hullPlatings;
    }

    public void setHullPlatings(Integer hullPlatings) {
        this.hullPlatings = hullPlatings;
    }

    @Override
    public String toString() {
        return "CargoDto{" +
               "id=" + id +
               ", engineModules=" + engineModules +
               ", powerCores=" + powerCores +
               ", commArrays=" + commArrays +
               ", hullPlatings=" + hullPlatings +
               '}';
    }
}
