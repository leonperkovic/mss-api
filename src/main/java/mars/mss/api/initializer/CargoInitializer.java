package mars.mss.api.initializer;

import mars.mss.api.repository.CargoRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CargoInitializer {

    private final CargoRepository cargoRepository;

    public CargoInitializer(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initializeSpaceships() {
        cargoRepository.deleteAll();
    }
}
