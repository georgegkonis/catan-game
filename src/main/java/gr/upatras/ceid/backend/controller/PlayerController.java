package gr.upatras.ceid.backend.controller;

import gr.upatras.ceid.backend.domain.request.player.CreatePlayerRequest;
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
    public ResponseEntity<?> get(
            @PathVariable String sessionId,
            @PathVariable String playerId) {

        playerService.getPlayer(sessionId, playerId);

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(
            @PathVariable String sessionId) {

        playerService.getPlayers(sessionId);

        throw new UnsupportedOperationException("Not implemented yet");
    }

    //region Resource Cards

    @GetMapping("{playerId}/resource-cards")
    public ResponseEntity<?> getResourceCards(
            @PathVariable String sessionId,
            @PathVariable String playerId) {

        playerService.getPlayerResourceCards(sessionId, playerId);

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PatchMapping("{playerId}/resource-cards")
    public ResponseEntity<?> addResourceCard(
            @PathVariable String sessionId,
            @PathVariable String playerId,
            @RequestParam String cardId) {

        playerService.addResourceCard(sessionId, playerId, cardId);

        throw new UnsupportedOperationException("Not implemented yet");
    }

    //endregion

    //region Development Cards

    @GetMapping("{playerId}/development-cards")
    public ResponseEntity<?> getDevelopmentCards(
            @PathVariable String sessionId,
            @PathVariable String playerId) {

        playerService.getPlayerDevelopmentCards(sessionId, playerId);

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PatchMapping("{playerId}/development-cards")
    public ResponseEntity<?> addDevelopmentCard(
            @PathVariable String sessionId,
            @PathVariable String playerId,
            @RequestParam String cardId) {

        playerService.addDevelopmentCard(sessionId, playerId, cardId);

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PatchMapping("{playerId}/development-cards/{cardId}")
    public ResponseEntity<?> playDevelopmentCard(
            @PathVariable String sessionId,
            @PathVariable String playerId,
            @PathVariable String cardId) {

        playerService.playDevelopmentCard(sessionId, playerId, cardId);

        throw new UnsupportedOperationException("Not implemented yet");
    }

    //endregion

    @GetMapping("{playerId}/victory-points")
    public ResponseEntity<?> countVictoryPoints(
            @PathVariable String sessionId,
            @PathVariable String playerId) {

        playerService.countVictoryPoints(sessionId, playerId);

        throw new UnsupportedOperationException("Not implemented yet");
    }
}
