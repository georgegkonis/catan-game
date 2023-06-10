package gr.upatras.ceid.backend.models;

import gr.upatras.ceid.backend.enums.Color;
import lombok.Data;

import java.util.List;

@Data
public class Player {
    private Long id;
    private String name;
    private Color color;
    private List<DevelopmentCard> developmentCards;
    private List<ResourceCard> resourceCards;
}
