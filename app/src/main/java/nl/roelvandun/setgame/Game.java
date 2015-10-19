package nl.roelvandun.setgame;

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


    }

    public Deck getDeck() {
        return deck;
    }

    public Set<Card> getTableCards() {
        return tableCards;
    }

    public
}
