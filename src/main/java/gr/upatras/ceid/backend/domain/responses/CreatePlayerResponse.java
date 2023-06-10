package gr.upatras.ceid.backend.domain.responses;

import gr.upatras.ceid.backend.enums.Color;

public record CreatePlayerResponse(
        String playerId,
        String userId,
        String playerName,
        Color playerColor
) {

}
