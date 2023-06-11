package gr.upatras.ceid.backend.model;

import gr.upatras.ceid.backend.enums.EdgePosition;
import gr.upatras.ceid.backend.enums.NodePosition;
import gr.upatras.ceid.backend.enums.NumberToken;
import gr.upatras.ceid.backend.enums.Terrain;
import lombok.Data;

import java.util.Map;

@Data
public class Tile {

    private String id;
    private NumberToken value;
    private Terrain terrain;
    private Integer row;
    private Integer col;
    private Map<NodePosition, String> nodeIds;
    private Map<EdgePosition, String> edgeIds;

    public boolean hasNode(String nodeId) {
        return true;
    }

    public boolean hasEdge(String edgeId) {
        return true;
    }
}
