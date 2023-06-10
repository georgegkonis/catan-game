package gr.upatras.ceid.backend.models;

import lombok.Data;

import java.util.List;

@Data
public class Bank {
    private String id;
    private List<DevelopmentCard> developmentCards;
    private List<ResourceCard> resourceCards;
}
