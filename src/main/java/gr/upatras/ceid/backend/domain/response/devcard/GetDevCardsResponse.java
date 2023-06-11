package gr.upatras.ceid.backend.domain.response.devcard;

import gr.upatras.ceid.backend.domain.dto.DevelopmentCardDto;

import java.util.List;

public record GetDevCardsResponse(List<DevelopmentCardDto> cards) {
}
