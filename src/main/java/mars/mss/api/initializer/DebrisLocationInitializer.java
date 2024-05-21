package mars.mss.api.initializer;

import mars.mss.api.model.DebrisLocation;
import mars.mss.api.repository.DebrisLocationRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DebrisLocationInitializer {

    private final DebrisLocationRepository debrisLocationRepository;

    public DebrisLocationInitializer(DebrisLocationRepository debrisLocationRepository) {
        this.debrisLocationRepository = debrisLocationRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initializeDebrisLocations() {
        debrisLocationRepository.deleteAll();
        var debris = List.of(
                new DebrisLocation(UUID.fromString("bff14063-4bb0-4517-ab22-786f82c5ab8c"), 10, false),
                new DebrisLocation(UUID.fromString("926f22cb-e288-41e9-9376-2c1f9dbe745e"), 20, false),
                new DebrisLocation(UUID.fromString("aed03dc5-3cc1-45c9-8b58-89f88084cc40"), 30, false),
                new DebrisLocation(UUID.fromString("5d27e8e0-8a72-4a8b-89f7-7210358005f7"), 50, false),
                new DebrisLocation(UUID.fromString("b8b7ab67-4f0d-4784-86ba-95d52cbb7bd4"), 100, false),
                new DebrisLocation(UUID.fromString("dae81582-99ac-4678-b538-541d8a0c7484"), 150, false)
        );
        debrisLocationRepository.saveAll(debris);
    }
}
