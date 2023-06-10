package gr.upatras.ceid.backend.models;

import gr.upatras.ceid.backend.enums.Color;
import lombok.Data;

@Data
public class Road {
    private Long id;
    private Color color;
}
