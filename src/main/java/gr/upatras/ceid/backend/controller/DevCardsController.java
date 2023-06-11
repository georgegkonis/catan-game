package gr.upatras.ceid.backend.controller;

import gr.upatras.ceid.backend.domain.response.devcard.GetDevCardsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sessions/{sessionId}/development-cards")
public class DevCardsController {

    @GetMapping()
    public ResponseEntity<GetDevCardsResponse> getDevelopmentCards(
            @PathVariable String sessionId,
            @RequestParam String playerId
    ) {
        var response = new GetDevCardsResponse(null);

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> buyDevelopmentCard() {
        return null;
    }


}
