package gr.upatras.ceid.backend.models;

import gr.upatras.ceid.backend.enums.Color;
import gr.upatras.ceid.backend.enums.NumberToken;
import gr.upatras.ceid.backend.enums.Terrain;
import lombok.Data;

import java.util.List;

@Data
public class HexTile {
    private Long id;
    private NumberToken value;
    private Color color;
    private Terrain terrain;
    private List<Long> nodeIds;
    private Double x;
    private Double y;
}
