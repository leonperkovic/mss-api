package mars.mss.api.controller;

import jakarta.transaction.Transactional;
import mars.mss.api.dto.DebrisLocationDto;
import mars.mss.api.repository.DebrisLocationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/debris-locations")
public class DebrisLocationController {
    private final DebrisLocationRepository debrisLocationRepository;

    public DebrisLocationController(DebrisLocationRepository debrisLocationRepository) {
        this.debrisLocationRepository = debrisLocationRepository;
    }

    @GetMapping
    public ResponseEntity<List<DebrisLocationDto>> getDebrisLocations(@RequestParam(required = false) Boolean cleared) {
        var debrisLocations = cleared == null ? debrisLocationRepository.findAll() : debrisLocationRepository.findAllByCleared(cleared);
        var debrisLocationDtos = debrisLocations.stream().map(DebrisLocationDto::fromModel).toList();
        return ResponseEntity.ok(debrisLocationDtos);
    }

    @Transactional
    @PostMapping("/{id}/mark-as-cleared")
    public ResponseEntity<Void> markAsCleared(@PathVariable UUID id) {
        debrisLocationRepository.markAsCleared(id);
        return ResponseEntity.noContent().build();
    }
}
