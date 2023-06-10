package gr.upatras.ceid.backend.controllers;

import gr.upatras.ceid.backend.domain.requests.CreatePlayerRequest;
import gr.upatras.ceid.backend.domain.requests.CreateSessionRequest;
import gr.upatras.ceid.backend.domain.responses.CreatePlayerResponse;
import gr.upatras.ceid.backend.domain.responses.CreateSessionResponse;
import gr.upatras.ceid.backend.domain.responses.GetSessionResponse;
import gr.upatras.ceid.backend.domain.responses.GetSessionsResponse;
import gr.upatras.ceid.backend.exceptions.SessionNotFoundException;
import gr.upatras.ceid.backend.services.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/sessions")
@AllArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @GetMapping("/{id}")
    public ResponseEntity<GetSessionResponse> get(@PathVariable String id) {
        var session = sessionService.getSession(id);

        var response = new GetSessionResponse(session.getId());

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<GetSessionsResponse> getAll() {
        var sessions = sessionService.getSessions();

        var response = new GetSessionsResponse();

        return ResponseEntity.ok().body(response);
    }

    @PostMapping()
    public ResponseEntity<CreateSessionResponse> add(@RequestBody CreateSessionRequest request) {
        var session = sessionService.createSession(request);

        var response = new CreateSessionResponse();

        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/{id}/players")
    public ResponseEntity<CreatePlayerResponse> addPlayer(@PathVariable String id, @RequestBody CreatePlayerRequest request) {
        var player = sessionService.createPlayer(id, request);

        var response = new CreatePlayerResponse(
                player.getId(),
                player.getUserId(),
                player.getName(),
                player.getColor()
        );

        return ResponseEntity.ok().body(response);
    }
}
