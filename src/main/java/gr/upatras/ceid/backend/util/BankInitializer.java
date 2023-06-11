package gr.upatras.ceid.backend.util;

import gr.upatras.ceid.backend.constants.GameConstants;
import gr.upatras.ceid.backend.enums.Color;
import gr.upatras.ceid.backend.enums.Resource;
import gr.upatras.ceid.backend.enums.Type;
import gr.upatras.ceid.backend.model.Bank;
import gr.upatras.ceid.backend.model.DevelopmentCard;
import gr.upatras.ceid.backend.model.ResourceCard;
import gr.upatras.ceid.backend.model.Road;
import gr.upatras.ceid.backend.model.colony.City;
import gr.upatras.ceid.backend.model.colony.Settlement;
import gr.upatras.ceid.backend.provider.IdProvider;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class BankInitializer {

    private final IdProvider<String> idProvider;

    public Bank initBank() {
        Bank bank = new Bank();

        bank.setRoads(createRoads());
        bank.setSettlements(createSettlements());
        bank.setCities(createCities());
        bank.setDevelopmentCards(createDevelopmentCards());
        bank.setResourceCards(createResourceCards());

        return bank;
    }

    private List<Road> createRoads() {
        var roads = new ArrayList<Road>();

        for (Color color : Color.values()) {
            for (int i = 0; i < GameConstants.ROADS; i++) {
                Road road = new Road(color);
                roads.add(road);
            }
        }
        return roads;
    }

    private List<Settlement> createSettlements() {
        var settlements = new ArrayList<Settlement>();

        for (Color color : Color.values()) {
            for (int i = 0; i < GameConstants.SETTLEMENTS; i++) {
                Settlement settlement = new Settlement(color);
                settlements.add(settlement);
            }
        }
        return settlements;
    }

    private List<City> createCities() {
        var cities = new ArrayList<City>();

        for (Color color : Color.values()) {
            for (int i = 0; i < GameConstants.CITIES; i++) {
                City city = new City(color);
                cities.add(city);
            }
        }
        return cities;
    }

    private List<DevelopmentCard> createDevelopmentCards() {
        var cards = new ArrayList<DevelopmentCard>();

        for (Type type : Type.values()) {
            for (int i = 0; i < type.getQuantity(); i++) {
                var card = new DevelopmentCard(idProvider.generateId(), type);
                cards.add(card);
            }
        }
        return cards;
    }

    private List<ResourceCard> createResourceCards() {
        var cards = new ArrayList<ResourceCard>();

        for (Resource resource : Resource.values()) {
            for (int i = 0; i < resource.getQuantity(); i++) {
                var card = new ResourceCard(idProvider.generateId(), resource);
                cards.add(card);
            }
        }
        return cards;
    }
}
