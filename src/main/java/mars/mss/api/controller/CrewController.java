package mars.mss.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/crews")
public class CrewController {
    @GetMapping(path = "/registered")
    public ResponseEntity<List<String>> getRegisteredCrews() {
        var registeredCrewIds = List.of(
                "68e57ce7-a7f5-4e45-bcd9-82fb897066b2",
                "03bff5fa-234a-446c-912c-97c12d9f240d",
                "4e95ec60-7760-4a63-bf49-83c671ae5f08",
                "7513ecd6-eee5-4035-880c-52fcb53f0759",
                "1fecbbe8-9f4f-433a-b4ca-a013eed5182e",
                "a8ddceb7-ebb1-4eff-84d8-099b73d4b1bc",
                "bddafd38-4607-41e9-b419-b4f43bf7519f",
                "c3a66e60-7bf6-4368-8438-cdcec821dce5",
                "4492b4ba-a0ef-4482-8d06-80599be07da2",
                "472fa331-6760-4057-a995-4500b43cf25e"
        );
        return ResponseEntity.ok(registeredCrewIds);
    }
}
