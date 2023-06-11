package gr.upatras.ceid.backend.domain.response.session;

import gr.upatras.ceid.backend.domain.dto.BankDto;
import gr.upatras.ceid.backend.domain.dto.BoardDto;
import gr.upatras.ceid.backend.domain.dto.PlayerDto;
import gr.upatras.ceid.backend.domain.dto.RoundDto;
import gr.upatras.ceid.backend.enums.SessionStatus;

// TODO: Implement
public record GetSessionResponse(
        String id,
        BoardDto board,
        BankDto bank,
        RoundDto round,
        SessionStatus status,
        PlayerDto[] players
) {

}
