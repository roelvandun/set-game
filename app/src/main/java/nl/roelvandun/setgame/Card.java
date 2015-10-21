package nl.roelvandun.setgame;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Card {

    private final Map<Class<? extends Characteristic>, Characteristic> characteristics;

    public final Amount amount;
    public final Color color;
    public final Filling filling;
    public final Form form;

    public Card(Color color, Amount amount, Filling filling, Form form) {
        this.color = color;
        this.amount = amount;
        this.filling = filling;
        this.form = form;

        characteristics = new HashMap<>(4);
        characteristics.put(Color.class, color);
        characteristics.put(Amount.class, amount);
        characteristics.put(Filling.class, filling);
        characteristics.put(Form.class, form);
    }
    /**
     * Marker interface
     */
    public interface Characteristic {

    }
    enum Amount implements Characteristic {
        ONE, TWO, THREE;

    }
    enum Color implements Characteristic {
        RED, GREEN, PURPLE;

    }
    enum Filling implements Characteristic {
        NONE, HALF, FULL;

    }
    enum Form implements Characteristic {
        DIAMONDS("<>"), WAVE("~"), OVAL("O");

        public final String character;

        Form(String character) {
            this.character = character;
        }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        switch (this.color) {
            case GREEN:
                sb.append("green");
                break;
            case PURPLE:
                sb.append("purple");
                break;
            case RED:
                sb.append("red");
                break;
        }

        sb.append(" \t ");

        switch (this.filling) {
            case NONE:
                sb.append("[ ]");
                break;
            case HALF:
                sb.append("[\\]");
                break;
            case FULL:
                sb.append("[*]");
                break;
        }

        sb.append(" \t ");

        switch (this.amount) {
            case ONE:
                sb.append(this.form.character);
                break;
            case TWO:
                sb.append(this.form.character);
                sb.append(this.form.character);
                break;
            case THREE:
                sb.append(this.form.character);
                sb.append(this.form.character);
                sb.append(this.form.character);
                break;
        }
        return sb.toString();
    }

    public Map<Class<? extends Characteristic>, Characteristic> getCharacteristics() {
        return Collections.unmodifiableMap(characteristics);
    }

}
