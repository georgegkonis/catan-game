package gr.upatras.ceid.backend.domain.request.session;

public record CreateSessionRequest(
        Boolean dessertCentered,
        Integer sessionSlots
) {
}
