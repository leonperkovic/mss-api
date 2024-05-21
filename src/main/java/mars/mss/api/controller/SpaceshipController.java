package mars.mss.api.controller;

import jakarta.transaction.Transactional;
import mars.mss.api.dto.SpaceshipDto;
import mars.mss.api.repository.SpaceshipRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/spaceships")
public class SpaceshipController {
    private final SpaceshipRepository spaceshipRepository;

    public SpaceshipController(SpaceshipRepository spaceshipRepository) {
        this.spaceshipRepository = spaceshipRepository;
    }

    @GetMapping
    public ResponseEntity<List<SpaceshipDto>> getSpaceships(@RequestParam(required = false) Boolean available) {
        var ships = available == null ? spaceshipRepository.findAll() : spaceshipRepository.findAllByAvailable(available);
        var shipDtos = ships.stream().map(SpaceshipDto::fromModel).toList();
        return ResponseEntity.ok(shipDtos);
    }

    @Transactional
    @PostMapping(path = "/{id}/mark-as-available")
    public ResponseEntity<Void> markAsAvailable(@PathVariable UUID id) {
        spaceshipRepository.markAsAvailable(id);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PostMapping(path = "/{id}/mark-as-unavailable")
    public ResponseEntity<Void> markAsUnavailable(@PathVariable UUID id) {
        spaceshipRepository.markAsUnavailable(id);
        return ResponseEntity.noContent().build();
    }
}
