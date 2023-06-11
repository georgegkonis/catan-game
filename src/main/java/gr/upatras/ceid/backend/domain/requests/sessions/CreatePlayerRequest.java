package gr.upatras.ceid.backend.domain.requests.sessions;

import gr.upatras.ceid.backend.enums.Color;

public record CreatePlayerRequest(
        String id,
        String userId,
        String playerName,
        Color playerColor
) {
}
