package mars.mss.api.controller;

import mars.mss.api.dto.CargoDto;
import mars.mss.api.dto.CargoValueDto;
import mars.mss.api.dto.StorageInfoDto;
import mars.mss.api.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cargo")
public class CargoController {
    private final CargoRepository cargoRepository;

    @Value("${mss.storage-capacity}")
    private Integer storageCapacity;

    public CargoController(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @GetMapping(path = "/storage-info")
    public ResponseEntity<StorageInfoDto> getStorageInfo() {
        var cargos = cargoRepository.findAll();
        var used = cargos.stream()
                .mapToInt(c -> c.getEngineModules() + c.getPowerCores() + c.getCommArrays() + c.getHullPlatings())
                .sum();
        var storageInfo = new StorageInfoDto();
        storageInfo.setCapacity(storageCapacity);
        storageInfo.setUsed(used);
        storageInfo.setFree(storageCapacity - used);

        return ResponseEntity.ok(storageInfo);
    }

    @PostMapping(path = "/store")
    public ResponseEntity<Void> storeCargo(@RequestBody CargoDto cargoDto) {
        cargoRepository.save(cargoDto.toModel());
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path = "/calculate-value")
    public ResponseEntity<CargoValueDto> calculateValue(@RequestBody CargoDto cargoDto) {
        var value = 0;
        if (cargoDto.getEngineModules() != null) value += cargoDto.getEngineModules() * 200;
        if (cargoDto.getPowerCores() != null) value += cargoDto.getPowerCores() * 150;
        if (cargoDto.getCommArrays() != null) value += cargoDto.getCommArrays() * 50;
        if (cargoDto.getHullPlatings() != null) value += cargoDto.getHullPlatings() * 100;
        return ResponseEntity.ok(new CargoValueDto(value));
    }
}
