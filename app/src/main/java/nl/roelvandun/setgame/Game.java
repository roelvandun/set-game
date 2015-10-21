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

    public boolean allSameAmount(Card cardOne, Card cardTwo, Card cardThree) {
        return allSameCharacteristic(Card.Amount.class, cardOne, cardTwo, cardThree);
    }

    public boolean allSameColor(Card cardOne, Card cardTwo, Card cardThree) {
        return allSameCharacteristic(Card.Color.class, cardOne, cardTwo, cardThree);
    }

    public boolean allDifferentAmount(Card cardOne, Card cardTwo, Card cardThree) {
        return !cardOne.amount.equals(cardTwo.amount) && !cardOne.amount.equals(cardThree.amount) && !cardTwo.amount.equals(cardThree.amount);
    }

    public boolean allSameCharacteristic(Class<? extends Card.Characteristic> characteristic, Card cardOne, Card cardTwo, Card cardThree) {
        Card.Characteristic one = cardOne.getCharacteristics().get(characteristic);
        Card.Characteristic two = cardTwo.getCharacteristics().get(characteristic);
        Card.Characteristic three = cardThree.getCharacteristics().get(characteristic);

        return one.equals(two) && one.equals(three);
    }

}
