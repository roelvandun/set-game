package nl.roelvandun.setgame;

public class Card {

    public final Amount amount;
    public final Color color;
    public final Filling filling;
    public final Form form;

    public Card(Color color, Amount amount, Filling filling, Form form) {
        this.color = color;
        this.amount = amount;
        this.filling = filling;
        this.form = form;
    }

    enum Amount {
        ONE, TWO, THREE;
    }

    enum Color {
        RED, GREEN, PURPLE;
    }

    enum Filling {
        NONE, HALF, FULL;
    }

    enum Form {
        DIAMONDS, WAVE, OVAL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (amount != card.amount) return false;
        if (color != card.color) return false;
        if (filling != card.filling) return false;
        return form == card.form;

    }

    @Override
    public int hashCode() {
        int result = amount.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + filling.hashCode();
        result = 31 * result + form.hashCode();
        return result;
    }
}
