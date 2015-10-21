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

    public boolean allSameCharacteristic(Class<? extends Card.Characteristic> characteristic, Card card1, Card card2, Card card3) {
        Card.Characteristic characteristic1 = card1.getCharacteristics().get(characteristic);
        Card.Characteristic characteristic2 = card2.getCharacteristics().get(characteristic);
        Card.Characteristic characteristic3 = card3.getCharacteristics().get(characteristic);

        return characteristic1.equals(characteristic2) && characteristic1.equals(characteristic3);
    }

    public boolean allDifferentCharacteristic(Class<? extends Card.Characteristic> characteristic, Card card1, Card card2, Card card3) {
        Card.Characteristic characteristic1 = card1.getCharacteristics().get(characteristic);
        Card.Characteristic characteristic2 = card2.getCharacteristics().get(characteristic);
        Card.Characteristic characteristic3 = card3.getCharacteristics().get(characteristic);

        return !characteristic1.equals(characteristic2) && !characteristic1.equals(characteristic3) && !characteristic2.equals(characteristic3);
    }

    public boolean isSet(Card card1, Card card2, Card card3) {
        boolean amountValid = allSameCharacteristic(Card.Amount.class, card1, card2, card3) ||
                allDifferentCharacteristic(Card.Amount.class, card1, card2, card3);
        boolean colorValid = allSameCharacteristic(Card.Color.class, card1, card2, card3) ||
                allDifferentCharacteristic(Card.Color.class, card1, card2, card3);
        boolean fillingValid = allSameCharacteristic(Card.Filling.class, card1, card2, card3) ||
                allDifferentCharacteristic(Card.Filling.class, card1, card2, card3);
        boolean formValid = allSameCharacteristic(Card.Form.class, card1, card2, card3) ||
                allDifferentCharacteristic(Card.Form.class, card1, card2, card3);

        return amountValid && colorValid && fillingValid && formValid;
    }

}
