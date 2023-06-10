package gr.upatras.ceid.backend.models;

import lombok.Data;

import java.util.Map;

@Data
public class Board {
    private Long id;
    private Map<Long, HexTile> hexTiles;
    private Map<Long, Node> nodes;
    private Map<Long, Edge> edges;
}