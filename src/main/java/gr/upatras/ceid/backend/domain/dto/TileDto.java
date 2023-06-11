package gr.upatras.ceid.backend.domain.dto;

import gr.upatras.ceid.backend.enums.NumberToken;
import gr.upatras.ceid.backend.enums.Terrain;

public record TileDto(
        String id,
        NumberToken value,
        Terrain terrain,
        Integer row,
        Integer col,
        NodeDto[] nodes,
        EdgeDto[] edges
) {
}
