package gr.upatras.ceid.backend.domain.requests.sessions;

public record CreateSessionRequest(
        Boolean dessertCentered,
        Integer numberOfPlayers
) {
}
