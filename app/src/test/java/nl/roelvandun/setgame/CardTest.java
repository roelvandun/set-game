package nl.roelvandun.setgame;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CardTest {

    @Test
    public void equalsWorks() throws Exception {
        Card card = new Card(Card.Color.GREEN, Card.Amount.THREE, Card.Filling.FULL, Card.Form.DIAMONDS);
        Card identicalCard =  new Card(Card.Color.GREEN, Card.Amount.THREE, Card.Filling.FULL, Card.Form.DIAMONDS);

        assertThat(card, equalTo(identicalCard));
    }

    @Test
    public void hashCodeWorks() throws Exception {
        Card card = new Card(Card.Color.GREEN, Card.Amount.THREE, Card.Filling.FULL, Card.Form.DIAMONDS);
        Card identicalCard =  new Card(Card.Color.GREEN, Card.Amount.THREE, Card.Filling.FULL, Card.Form.DIAMONDS);

        assertThat(card.hashCode(), equalTo(identicalCard.hashCode()));
    }
}