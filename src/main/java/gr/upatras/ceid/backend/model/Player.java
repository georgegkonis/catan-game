package gr.upatras.ceid.backend.model;

import gr.upatras.ceid.backend.enums.Color;
import lombok.Data;

import java.util.List;

@Data
public class Player {
    private String id;
    private String userId;
    private String name;
    private Color color;
    private List<DevelopmentCard> developmentCards;
    private List<ResourceCard> resourceCards;
}
