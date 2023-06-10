package gr.upatras.ceid.backend.models.colony;

import gr.upatras.ceid.backend.models.DevelopmentCard;
import gr.upatras.ceid.backend.models.ResourceCard;

import java.util.List;

public class Bank {
    private Long id;
    private List<DevelopmentCard> developmentCards;
    private List<ResourceCard> resourceCards;
}
