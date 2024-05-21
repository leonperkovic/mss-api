package mars.mss.api.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "cargo")
public class Cargo {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "engine_modules")
    private Integer engineModules;
    @Column(name = "power_cores")
    private Integer powerCores;
    @Column(name = "comm_arrays")
    private Integer commArrays;
    @Column(name = "hull_platings")
    private Integer hullPlatings;

    public Cargo() {}

    public Cargo(UUID id, Integer engineModules, Integer powerCores, Integer commArrays, Integer hullPlatings) {
        this.id = id;
        this.engineModules = engineModules;
        this.powerCores = powerCores;
        this.commArrays = commArrays;
        this.hullPlatings = hullPlatings;
    }

    @PrePersist
    public void onCreate() {
        if (id == null) id = UUID.randomUUID();
        if (engineModules == null) engineModules = 0;
        if (powerCores == null) powerCores = 0;
        if (commArrays == null) commArrays = 0;
        if (hullPlatings == null) hullPlatings = 0;
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
        return "Cargo{" +
               "id=" + id +
               ", engineModules=" + engineModules +
               ", powerCores=" + powerCores +
               ", commArrays=" + commArrays +
               ", hullPlatings=" + hullPlatings +
               '}';
    }
}
