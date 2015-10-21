package nl.roelvandun.setgame;

import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.Set;

public class Game {

    private final Deck deck;
    private Set<Card> tableCards = new HashSet<>();

    public Game() {
        this.deck = new Deck();
    }

    /**
     * Starts the game by:
     * <ol>
     *     <li>shuffling the deck</li>
     *     <li>putting 12 cards on the table</li>
     * </ol>
     */
    public void start() {
        deck.shuffle();

        draw3Cards();
        draw3Cards();
        draw3Cards();
        draw3Cards();
    }

    public Deck getDeck() {
        return deck;
    }

    public Set<Card> getTableCards() {
        return tableCards;
    }

    public void draw3Cards() throws EmptyStackException {
        getTableCards().add(getDeck().draw());
        getTableCards().add(getDeck().draw());
        getTableCards().add(getDeck().draw());
    }

    public boolean haveSameCount(Card cardOne, Card cardTwo, Card cardThree) {
        return cardOne.amount.equals(cardTwo.amount) && cardOne.amount.equals(cardThree.amount);
    }

    public boolean haveSameColor(Card cardOne, Card cardTwo, Card cardThree) {
        return cardOne.color.equals(cardTwo.color) && cardOne.color.equals(cardThree.color);
    }

}
