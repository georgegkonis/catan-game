package gr.upatras.ceid.backend.model;

import gr.upatras.ceid.backend.enums.Color;
import gr.upatras.ceid.backend.enums.Resource;
import gr.upatras.ceid.backend.exception.insufficient.*;
import gr.upatras.ceid.backend.model.colony.City;
import gr.upatras.ceid.backend.model.colony.Settlement;
import lombok.Data;

import java.util.List;

@Data
public class Bank {

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
        if (developmentCards.isEmpty()) throw new InsufficientDevelopmentCardsException();
        return developmentCards.remove(0);
    }

    public List<ResourceCard> removeResourceCards(Resource resource, int amount) {
        List<ResourceCard> resourceCards = this.resourceCards.stream()
                .filter(card -> card.getResource() == resource)
                .limit(amount)
                .toList();
        if (resourceCards.size() < amount) throw new InsufficientResourceCardsException();
        this.resourceCards.removeIf(resourceCards::contains);
        return resourceCards;
    }
}
