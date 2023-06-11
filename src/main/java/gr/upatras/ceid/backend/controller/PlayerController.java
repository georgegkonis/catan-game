package gr.upatras.ceid.backend.controller;

import gr.upatras.ceid.backend.domain.request.sessions.CreatePlayerRequest;
import gr.upatras.ceid.backend.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sessions/{sessionId}/players")
@AllArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PutMapping()
    public ResponseEntity<?> createPlayer(
            @PathVariable String sessionId,
            @RequestBody CreatePlayerRequest request) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<?> getPlayer(
            @PathVariable String sessionId,
            @PathVariable String playerId) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping
    public ResponseEntity<?> getPlayers(
            @PathVariable String sessionId) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    //region Resource Cards

    @GetMapping("{playerId}/resource-cards")
    public ResponseEntity<?> getPlayerResourceCards(
            @PathVariable String sessionId,
            @PathVariable String playerId) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PatchMapping("{playerId}/resource-cards")
    public ResponseEntity<?> addResourceCard(
            @PathVariable String sessionId,
            @PathVariable String playerId,
            @RequestParam String cardId) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    //endregion

    //region Development Cards

    @GetMapping("{playerId}/development-cards")
    public ResponseEntity<?> getPlayerDevelopmentCards(
            @PathVariable String sessionId,
            @PathVariable String playerId) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PatchMapping("{playerId}/development-cards")
    public ResponseEntity<?> addDevelopmentCard(
            @PathVariable String sessionId,
            @PathVariable String playerId,
            @RequestParam String cardId) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PatchMapping("{playerId}/development-cards/{cardId}")
    public ResponseEntity<?> playPlayerDevelopmentCard(
            @PathVariable String sessionId,
            @PathVariable String playerId,
            @PathVariable String cardId) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    //endregion

    @GetMapping("{playerId}/victory-points")
    public ResponseEntity<?> countPlayerVictoryPoints(
            @PathVariable String sessionId,
            @PathVariable String playerId) {

        throw new UnsupportedOperationException("Not implemented yet");
    }
}
