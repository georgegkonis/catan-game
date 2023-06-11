package gr.upatras.ceid.backend.controller;

import gr.upatras.ceid.backend.domain.request.player.CreatePlayerRequest;
import gr.upatras.ceid.backend.domain.request.session.CreateSessionRequest;
import gr.upatras.ceid.backend.domain.response.session.CreatePlayerResponse;
import gr.upatras.ceid.backend.domain.response.session.CreateSessionResponse;
import gr.upatras.ceid.backend.domain.response.session.GetSessionResponse;
import gr.upatras.ceid.backend.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/sessions")
@AllArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @GetMapping("/{sessionId}")
    public ResponseEntity<GetSessionResponse> getSession(
            @PathVariable String sessionId) {
        var session = sessionService.getSession(sessionId);

        // TODO: Need to add automapper
        var response = new GetSessionResponse(
                session.getId(),
                null,
                null,
                null,
                session.getStatus(),
                null
        );

        return ResponseEntity.ok().body(response);
    }

    @PostMapping()
    public ResponseEntity<CreateSessionResponse> addSession(
            @RequestBody CreateSessionRequest request) {
        var session = sessionService.createSession(request);

        var response = new CreateSessionResponse(
                session.getId(),
                session.getSlots(),
                session.getStatus()
        );
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/{sessionId}/players")
    public ResponseEntity<CreatePlayerResponse> addPlayerToSession(
            @PathVariable String sessionId,
            @RequestBody CreatePlayerRequest request) {
        var player = sessionService.createPlayer(sessionId, request);

        var response = new CreatePlayerResponse(
                player.getId(),
                player.getUserId(),
                player.getName(),
                player.getColor()
        );
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/{sessionId}/start")
    public ResponseEntity<Void> startSession(
            @PathVariable String sessionId) {
        sessionService.startSession(sessionId);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{sessionId}")
    public ResponseEntity<Void> deleteSession(
            @PathVariable String sessionId) {
        sessionService.deleteSession(sessionId);

        return ResponseEntity.ok().build();
    }
}
