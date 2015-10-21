package nl.roelvandun.setgame;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SetCheckerTest {

    private List<Card> tableCards;
    private SetChecker setChecker;

    @Before
    public void setUp() throws Exception {
        tableCards = new ArrayList<>();
        setChecker = new SetChecker();
    }

    @Test
    public void isSet_3same1differ_true() throws Exception {
        Card g1nw = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.WAVE);
        Card g1no = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.OVAL);
        Card g1nd = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.DIAMOND);

        assertTrue(setChecker.isSet(g1nw, g1no, g1nd));
    }

    @Test
    public void isSet_1fault_false() throws Exception {
        Card g1nw = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.WAVE);
        Card g2no = new Card(Card.Color.GREEN, Card.Amount.TWO, Card.Filling.NONE, Card.Form.OVAL);
        Card g2nd = new Card(Card.Color.GREEN, Card.Amount.TWO, Card.Filling.NONE, Card.Form.DIAMOND);

        assertFalse(setChecker.isSet(g1nw, g2no, g2nd));
    }

    //region AMOUNT
    @Test
    public void allSameAmount_allSame_true() throws Exception {
        Card g1nwCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.WAVE);
        Card r1hoCard = new Card(Card.Color.RED, Card.Amount.ONE, Card.Filling.HALF, Card.Form.OVAL);
        Card p1fdCard = new Card(Card.Color.PURPLE, Card.Amount.ONE, Card.Filling.FULL, Card.Form.DIAMOND);

        assertTrue(setChecker.allSameCharacteristic(Card.Amount.class, g1nwCard, r1hoCard, p1fdCard));
    }

    @Test
    public void allSameAmount_1differs_false() throws Exception {
        Card g1nwCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.WAVE);
        Card r1hoCard = new Card(Card.Color.RED, Card.Amount.ONE, Card.Filling.HALF, Card.Form.OVAL);
        Card p2fdCard = new Card(Card.Color.PURPLE, Card.Amount.TWO, Card.Filling.FULL, Card.Form.DIAMOND);

        assertFalse(setChecker.allSameCharacteristic(Card.Amount.class, g1nwCard, r1hoCard, p2fdCard));
    }

    @Test
    public void allSameAmount_2differ_false() throws Exception {
        Card g1nwCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.WAVE);
        Card r3hoCard = new Card(Card.Color.RED, Card.Amount.THREE, Card.Filling.HALF, Card.Form.OVAL);
        Card p2fdCard = new Card(Card.Color.PURPLE, Card.Amount.TWO, Card.Filling.FULL, Card.Form.DIAMOND);

        assertFalse(setChecker.allSameCharacteristic(Card.Amount.class, g1nwCard, r3hoCard, p2fdCard));
    }

    @Test
    public void allDifferentAmount_allDiffer_true() throws Exception {
        Card g1nw = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.WAVE);
        Card g2nw = new Card(Card.Color.GREEN, Card.Amount.TWO, Card.Filling.NONE, Card.Form.WAVE);
        Card g3nw = new Card(Card.Color.GREEN, Card.Amount.THREE, Card.Filling.NONE, Card.Form.WAVE);

        assertTrue(setChecker.allDifferentCharacteristic(Card.Amount.class, g1nw, g2nw, g3nw));
    }

    @Test
    public void allDifferentAmount_2same_false() throws Exception {
        Card g1nw = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.WAVE);
        Card g1hw = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.HALF, Card.Form.WAVE);
        Card g3nw = new Card(Card.Color.GREEN, Card.Amount.THREE, Card.Filling.NONE, Card.Form.WAVE);

        assertFalse(setChecker.allDifferentCharacteristic(Card.Amount.class, g1nw, g1hw, g3nw));
    }

    @Test
    public void allDifferentAmount_3same_false() throws Exception {
        Card g1nw = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.WAVE);
        Card g1hw = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.HALF, Card.Form.WAVE);
        Card g1fw = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.FULL, Card.Form.WAVE);

        assertFalse(setChecker.allDifferentCharacteristic(Card.Amount.class, g1nw, g1hw, g1fw));
    }
    //endregion

    //region COLOR
    @Test
    public void allSameColor_sameColor_true() throws Exception {
        Card g1nwCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.WAVE);
        Card g1hoCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.HALF, Card.Form.OVAL);
        Card g1fdCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.FULL, Card.Form.DIAMOND);

        assertTrue(setChecker.allSameCharacteristic(Card.Color.class, g1nwCard, g1hoCard, g1fdCard));
    }

    @Test
    public void allSameColor_oneDiffers_false() throws Exception {
        Card g1nwCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.WAVE);
        Card r1hoCard = new Card(Card.Color.RED, Card.Amount.ONE, Card.Filling.HALF, Card.Form.OVAL);
        Card g1fdCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.FULL, Card.Form.DIAMOND);

        assertFalse(setChecker.allSameCharacteristic(Card.Color.class, g1nwCard, r1hoCard, g1fdCard));
    }

    @Test
    public void allSameColor_twoDiffer_false() throws Exception {
        Card g1nwCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.WAVE);
        Card r1hoCard = new Card(Card.Color.RED, Card.Amount.ONE, Card.Filling.HALF, Card.Form.OVAL);
        Card p1fdCard = new Card(Card.Color.PURPLE, Card.Amount.ONE, Card.Filling.FULL, Card.Form.DIAMOND);

        assertFalse(setChecker.allSameCharacteristic(Card.Color.class, g1nwCard, r1hoCard, p1fdCard));
    }
    //endregion

    @Test
    public void containsSet_0sets_null() throws Exception {
        tableCards.add(new Card(Card.Color.GREEN, Card.Amount.TWO, Card.Filling.FULL, Card.Form.OVAL));
        tableCards.add(new Card(Card.Color.PURPLE, Card.Amount.TWO, Card.Filling.FULL, Card.Form.OVAL));
        tableCards.add(new Card(Card.Color.PURPLE, Card.Amount.TWO, Card.Filling.FULL, Card.Form.WAVE));

        assertThat(setChecker.containsSet(tableCards), nullValue());
    }

    @Test
    public void containsSet_3cards1set_thatSet() throws Exception {
        Card setCard1 = new Card(Card.Color.GREEN, Card.Amount.TWO, Card.Filling.FULL, Card.Form.OVAL);
        Card setCard2 = new Card(Card.Color.PURPLE, Card.Amount.TWO, Card.Filling.FULL, Card.Form.DIAMOND);
        Card setCard3 = new Card(Card.Color.RED, Card.Amount.TWO, Card.Filling.FULL, Card.Form.WAVE);

        tableCards.add(setCard1);
        tableCards.add(setCard2);
        tableCards.add(setCard3);

        assertThat(setChecker.containsSet(tableCards), hasItems(setCard1, setCard2, setCard3));
    }

    @Test
    public void containsSet_6cards1set_thatSet() throws Exception {
        Card setCard1 = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.HALF, Card.Form.DIAMOND);
        Card setCard2 = new Card(Card.Color.PURPLE, Card.Amount.TWO, Card.Filling.FULL, Card.Form.DIAMOND);
        Card setCard3 = new Card(Card.Color.RED, Card.Amount.THREE, Card.Filling.NONE, Card.Form.DIAMOND);
        Card randomCard1 = new Card(Card.Color.GREEN, Card.Amount.THREE, Card.Filling.FULL, Card.Form.DIAMOND);
        Card randomCard2 = new Card(Card.Color.PURPLE, Card.Amount.TWO, Card.Filling.HALF, Card.Form.OVAL);
        Card randomCard3 = new Card(Card.Color.RED, Card.Amount.THREE, Card.Filling.FULL, Card.Form.WAVE);

        tableCards.add(setCard1);
        tableCards.add(setCard2);
        tableCards.add(setCard3);
        tableCards.add(randomCard1);
        tableCards.add(randomCard2);
        tableCards.add(randomCard3);

        assertThat(setChecker.containsSet(tableCards), hasItems(setCard1, setCard2, setCard3));
    }

    @Test
    public void containsSet_6cards0sets_null() throws Exception {
        Card card1 = new Card(Card.Color.RED, Card.Amount.THREE, Card.Filling.NONE, Card.Form.DIAMOND);
        Card card2 = new Card(Card.Color.PURPLE, Card.Amount.TWO, Card.Filling.HALF, Card.Form.DIAMOND);
        Card card3 = new Card(Card.Color.GREEN, Card.Amount.TWO, Card.Filling.FULL, Card.Form.DIAMOND);
        Card card4 = new Card(Card.Color.RED, Card.Amount.TWO, Card.Filling.HALF, Card.Form.OVAL);
        Card card5 = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.FULL, Card.Form.WAVE);
        Card card6 = new Card(Card.Color.PURPLE, Card.Amount.ONE, Card.Filling.HALF, Card.Form.OVAL);

        tableCards.add(card1);
        tableCards.add(card2);
        tableCards.add(card3);
        tableCards.add(card4);
        tableCards.add(card5);
        tableCards.add(card6);

        assertNull(setChecker.containsSet(tableCards));
    }
}