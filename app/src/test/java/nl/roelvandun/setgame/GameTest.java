package nl.roelvandun.setgame;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void game_constructed_hasADeck() throws Exception {
        assertThat(game.getDeck(), notNullValue());
    }

    @Test
    public void drawCards_atLeast3InStack_adds3cardsToTable() throws Exception {
        int initialTableCardsCount = game.getTableCards().size();

        game.draw3Cards();

        int afterDrawingTableCardsCount = game.getTableCards().size();

        assertThat(afterDrawingTableCardsCount, equalTo(initialTableCardsCount + 3));
    }

    @Test(expected = EmptyStackException.class)
    public void drawCards_emptyStack_throwsException() throws Exception {
        final int ONE_TOO_MUCH = DeckTest.FULL_STACK_SIZE / 3 + 1;

        for (int i = 0; i < ONE_TOO_MUCH; i++) {
            game.draw3Cards();
        }
    }

    @Test
    public void start_tableHas12Cards() throws Exception {
        game.start();

        assertThat(game.getTableCards().size(), equalTo(12));
    }

    @Test
    public void allSameAmount_sameAmount_true() throws Exception {
        Card g1nwCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.WAVE);
        Card r1hoCard = new Card(Card.Color.RED, Card.Amount.ONE, Card.Filling.HALF, Card.Form.OVAL);
        Card p1fdCard = new Card(Card.Color.PURPLE, Card.Amount.ONE, Card.Filling.FULL, Card.Form.DIAMONDS);

        assertTrue(game.allSameAmount(g1nwCard, r1hoCard, p1fdCard));
    }

    @Test
    public void allSameAmount_oneDiffers_false() throws Exception {
        Card g1nwCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.WAVE);
        Card r1hoCard = new Card(Card.Color.RED, Card.Amount.ONE, Card.Filling.HALF, Card.Form.OVAL);
        Card p2fdCard = new Card(Card.Color.PURPLE, Card.Amount.TWO, Card.Filling.FULL, Card.Form.DIAMONDS);

        assertFalse(game.allSameAmount(g1nwCard, r1hoCard, p2fdCard));
    }

    @Test
    public void allSameAmount_twoDiffer_false() throws Exception {
        Card g1nwCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.WAVE);
        Card r3hoCard = new Card(Card.Color.RED, Card.Amount.THREE, Card.Filling.HALF, Card.Form.OVAL);
        Card p2fdCard = new Card(Card.Color.PURPLE, Card.Amount.TWO, Card.Filling.FULL, Card.Form.DIAMONDS);

        assertFalse(game.allSameAmount(g1nwCard, r3hoCard, p2fdCard));
    }

    @Test
    public void allSameColor_sameColor_true() throws Exception {
        Card g1nwCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.WAVE);
        Card g1hoCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.HALF, Card.Form.OVAL);
        Card g1fdCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.FULL, Card.Form.DIAMONDS);

        assertTrue(game.allSameColor(g1nwCard, g1hoCard, g1fdCard));
    }

    @Test
    public void allSameColor_oneDiffers_false() throws Exception {
        Card g1nwCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.WAVE);
        Card r1hoCard = new Card(Card.Color.RED, Card.Amount.ONE, Card.Filling.HALF, Card.Form.OVAL);
        Card g1fdCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.FULL, Card.Form.DIAMONDS);

        assertFalse(game.allSameColor(g1nwCard, r1hoCard, g1fdCard));
    }

    @Test
    public void allSameColor_twoDiffer_false() throws Exception {
        Card g1nwCard = new Card(Card.Color.GREEN, Card.Amount.ONE, Card.Filling.NONE, Card.Form.WAVE);
        Card r1hoCard = new Card(Card.Color.RED, Card.Amount.ONE, Card.Filling.HALF, Card.Form.OVAL);
        Card p1fdCard = new Card(Card.Color.PURPLE, Card.Amount.ONE, Card.Filling.FULL, Card.Form.DIAMONDS);

        assertFalse(game.allSameColor(g1nwCard, r1hoCard, p1fdCard));
    }

}