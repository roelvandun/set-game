package nl.roelvandun.setgame;

import android.content.Context;
import android.view.View;

public class Card {

    private CardValue cardValue;
    private int id;
    private View view;

    public Card(Context context, int id, CardValue cardValue) {
        this.id = id;
        this.cardValue = cardValue;
        this.view = new CardView(context, cardValue);
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public View getView() {
        return view;
    }

    public int getId() {
        return id;
    }
}
