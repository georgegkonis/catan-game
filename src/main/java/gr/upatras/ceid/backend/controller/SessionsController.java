package gr.upatras.ceid.backend.controller;

import gr.upatras.ceid.backend.domain.request.sessions.CreatePlayerRequest;
import gr.upatras.ceid.backend.domain.request.sessions.CreateSessionRequest;
import gr.upatras.ceid.backend.domain.response.session.CreatePlayerResponse;
import gr.upatras.ceid.backend.domain.response.session.CreateSessionResponse;
import gr.upatras.ceid.backend.domain.response.session.GetSessionResponse;
import gr.upatras.ceid.backend.domain.response.session.GetSessionsResponse;
import gr.upatras.ceid.backend.service.SessionsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/sessions")
@AllArgsConstructor
public class SessionsController {

    private final SessionsService sessionsService;

    @GetMapping("/{id}")
    public ResponseEntity<GetSessionResponse> get(@PathVariable String id) {
        var session = sessionsService.getSession(id);

        var response = new GetSessionResponse(session.getId());

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<GetSessionsResponse> getAll() {
        var sessions = sessionsService.getSessions();

        var response = new GetSessionsResponse();

        return ResponseEntity.ok().body(response);
    }

    @PostMapping()
    public ResponseEntity<CreateSessionResponse> add(@RequestBody CreateSessionRequest request) {
        var session = sessionsService.createSession(request);

        var response = new CreateSessionResponse(session.getId());

        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/{id}/players")
    public ResponseEntity<CreatePlayerResponse> addPlayer(@PathVariable String id, @RequestBody CreatePlayerRequest request) {
        var player = sessionsService.createPlayer(id, request);

        var response = new CreatePlayerResponse(
                player.getId(),
                player.getUserId(),
                player.getName(),
                player.getColor()
        );
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        sessionsService.deleteSession(id);

        return ResponseEntity.ok().build();
    }
}
