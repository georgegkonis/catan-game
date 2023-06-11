package gr.upatras.ceid.backend.domain.request.sessions;

public record CreateSessionRequest(
        Boolean dessertCentered,
        Integer sessionSlots
) {
}
