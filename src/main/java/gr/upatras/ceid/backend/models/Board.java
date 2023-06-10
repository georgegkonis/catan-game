package gr.upatras.ceid.backend.models;

import lombok.Data;

import java.util.List;

@Data
public class Board {
    private String id;
    private List<Tile> tiles;
    private List<Node> nodes;
    private List<Edge> edges;
}