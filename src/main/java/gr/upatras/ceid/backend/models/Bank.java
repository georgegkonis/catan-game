package gr.upatras.ceid.backend.models;

import gr.upatras.ceid.backend.enums.Color;
import gr.upatras.ceid.backend.exceptions.insufficient.*;
import gr.upatras.ceid.backend.models.colony.City;
import gr.upatras.ceid.backend.models.colony.Settlement;
import lombok.Data;

import java.util.List;

@Data
public class Bank {

    private String id;
    private List<Road> roads;
    private List<Settlement> settlements;
    private List<City> cities;
    private List<DevelopmentCard> developmentCards;
    private List<ResourceCard> resourceCards;

    public Road removeRoad(Color color) {
        var roadOfColor = roads.stream()
                .filter(road -> road.getColor() == color)
                .findAny()
                .orElseThrow(InsufficientRoadsException::new);
        roads.remove(roadOfColor);
        return roadOfColor;
    }

    public Settlement removeSettlement(Color color) {
        var settlementOfColor = settlements.stream()
                .filter(settlement -> settlement.getColor() == color)
                .findAny()
                .orElseThrow(InsufficientSettlementsException::new);
        settlements.remove(settlementOfColor);
        return settlementOfColor;
    }

    public City removeCity(Color color) {
        var cityOfColor = cities.stream()
                .filter(city -> city.getColor() == color)
                .findAny()
                .orElseThrow(InsufficientCitiesException::new);
        cities.remove(cityOfColor);
        return cityOfColor;
    }

    public DevelopmentCard removeDevelopmentCard() {
        DevelopmentCard card = developmentCards.remove(0);
        if (card == null) throw new InsufficientDevelopmentCardsException();
        return card;
    }

    public ResourceCard removeResourceCard() {
        ResourceCard card = resourceCards.remove(0);
        if (card == null) throw new InsufficientResourceCardsException();
        return card;
    }
}
