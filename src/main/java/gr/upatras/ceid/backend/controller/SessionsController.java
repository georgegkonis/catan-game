package gr.upatras.ceid.backend.controller;

import gr.upatras.ceid.backend.domain.request.sessions.CreatePlayerRequest;
import gr.upatras.ceid.backend.domain.request.sessions.CreateSessionRequest;
import gr.upatras.ceid.backend.domain.response.session.CreatePlayerResponse;
import gr.upatras.ceid.backend.domain.response.session.CreateSessionResponse;
import gr.upatras.ceid.backend.domain.response.session.GetSessionResponse;
import gr.upatras.ceid.backend.service.SessionsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/sessions")
@AllArgsConstructor
public class SessionsController {

    private final SessionsService sessionsService;

    @GetMapping("/{sessionId}")
    public ResponseEntity<GetSessionResponse> getSession(
            @PathVariable String sessionId) {
        var session = sessionsService.getSession(sessionId);

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
        var session = sessionsService.createSession(request);

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
        var player = sessionsService.createPlayer(sessionId, request);

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
        sessionsService.startSession(sessionId);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{sessionId}")
    public ResponseEntity<Void> deleteSession(
            @PathVariable String sessionId) {
        sessionsService.deleteSession(sessionId);

        return ResponseEntity.ok().build();
    }
}
