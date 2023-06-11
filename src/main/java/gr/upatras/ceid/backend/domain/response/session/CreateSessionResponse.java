package gr.upatras.ceid.backend.domain.response.session;

import gr.upatras.ceid.backend.enums.SessionStatus;

public record CreateSessionResponse(
        String id,
        Integer slots,
        SessionStatus status

) {
}
