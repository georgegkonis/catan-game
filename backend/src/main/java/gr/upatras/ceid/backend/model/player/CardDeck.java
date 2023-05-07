package gr.upatras.ceid.backend.model.player;

import gr.upatras.ceid.backend.model.card.Card;

import java.util.ArrayList;
import java.util.List;

public class CardDeck<T extends Card> {
    
    private final List<T> cards;
    
    public CardDeck() {
        this.cards = new ArrayList<>();
    }

    public CardDeck(List<T> cards) {
        this.cards = cards;
    }
    
    public void shuffle() {}
    
    public void addCard(T card) {
        cards.add(card);
    }
    
    public boolean removeCard(T card) {
        return cards.remove(card);
    }
    
    public List<T> getCards() {
        return cards;
    }
}
