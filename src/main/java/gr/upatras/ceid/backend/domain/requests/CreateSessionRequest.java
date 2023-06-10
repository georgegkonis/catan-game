package gr.upatras.ceid.backend.domain.requests;

public record CreateSessionRequest(
        Boolean dessertCentered,
        Integer numberOfPlayers
) {
}
