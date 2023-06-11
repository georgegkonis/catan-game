package gr.upatras.ceid.backend.controller;

import gr.upatras.ceid.backend.service.RoundService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sessions/{sessionId}/round")
@AllArgsConstructor
public class RoundController {

    private final RoundService roundService;

    @GetMapping("/current")
    public ResponseEntity<?> getCurrentRound(@PathVariable String sessionId) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PatchMapping("/start")
    public ResponseEntity<?> startRound(@PathVariable String sessionId) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PatchMapping("/next-phase")
    public ResponseEntity<?> nextRoundPhase(@PathVariable String sessionId) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PatchMapping("/end")
    public ResponseEntity<?> endRound(@PathVariable String sessionId) {

        throw new UnsupportedOperationException("Not implemented yet");
    }
}
