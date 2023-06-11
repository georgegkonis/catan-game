package gr.upatras.ceid.backend.model;

import gr.upatras.ceid.backend.enums.Color;
import gr.upatras.ceid.backend.exception.insufficient.InsufficientResourceCardsException;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Data
public class Player {

    private final String id;
    private String userId;
    private String name;
    private Color color;
    private List<DevelopmentCard> developmentCards;
    private List<ResourceCard> resourceCards;

    public DevelopmentCard removeDevelopmentCard(String cardId) {
        var devCards = developmentCards.stream()
                .filter(card -> Objects.equals(card.getId(), cardId))
                .findAny()
                .orElseThrow();
        developmentCards.remove(devCards);
        return devCards;
    }

    public ResourceCard removeResourceCard() {
        ResourceCard card = resourceCards.remove(0);
        if (card == null) throw new InsufficientResourceCardsException();
        return card;
    }

    public List<ResourceCard> removeResourceCards(String... cardIds) {
        var resCards = this.resourceCards.stream()
                .filter(card -> Arrays.asList(cardIds).contains(card.getId()))
                .toList();
        this.resourceCards.removeIf(card -> Arrays.asList(cardIds).contains(card.getId()));
        return resCards;
    }
}

