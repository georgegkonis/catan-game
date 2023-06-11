package gr.upatras.ceid.backend.model;

import gr.upatras.ceid.backend.enums.NumberToken;
import gr.upatras.ceid.backend.enums.Terrain;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Tile {
    private String id;
    private NumberToken value;
    private Terrain terrain;
    private Integer row;
    private Integer col;
    private List<Long> nodeIds;
    private Map<String, Node> cornerNodes;
    private Map<String, Edge> sideEdges;
}
