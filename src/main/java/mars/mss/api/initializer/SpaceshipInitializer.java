package mars.mss.api.initializer;

import mars.mss.api.model.Spaceship;
import mars.mss.api.repository.SpaceshipRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SpaceshipInitializer {

    private final SpaceshipRepository spaceshipRepository;

    public SpaceshipInitializer(SpaceshipRepository spaceshipRepository) {
        this.spaceshipRepository = spaceshipRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initializeSpaceships() {
        spaceshipRepository.deleteAll();
        var spaceships = List.of(
                new Spaceship(UUID.fromString("5a5ac825-aaa1-4dc0-b39f-425bdf457d68"), "Bebop", 5, 15, true),
                new Spaceship(UUID.fromString("697da598-9a0e-4c2a-aad4-39fbd0cdad34"), "Rocinante", 15, 30, true),
                new Spaceship(UUID.fromString("0d7519ca-7417-4deb-8152-11555710aaa6"), "Donnager", 200, 500, true)
        );
        spaceshipRepository.saveAll(spaceships);
    }
}
