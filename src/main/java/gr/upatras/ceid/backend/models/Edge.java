package gr.upatras.ceid.backend.models;

import lombok.Data;

@Data
public class Edge {
    private Long id;
    private Long node1Id;
    private Long node2Id;
    private Road road;
    private Double x;
    private Double y;

    public boolean hasRoad() {
        return road != null;
    }
}
