package gr.upatras.ceid.backend.models;

import gr.upatras.ceid.backend.enums.Port;
import gr.upatras.ceid.backend.models.colony.Colony;
import lombok.Data;

import java.util.List;

@Data
public class Node {
    private Long id;
    private Colony colony;
    private Port port;
    private List<Long> edgeIds;
    private List<Long> tileIds;
    private Integer row;
    private Integer col;

    public Node(Integer row, Integer col) {
        this.row = row;
        this.col = col;
    }

    public boolean hasColony() {
        return colony != null;
    }

    public boolean hasPort() {
        return port != null;
    }
}
