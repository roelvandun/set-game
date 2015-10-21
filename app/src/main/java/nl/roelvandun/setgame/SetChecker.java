package nl.roelvandun.setgame;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SetChecker {

    private static final String TAG = SetChecker.class.getSimpleName();

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
        Log.d(TAG, "checking " + card1 + ", " + card2 + ", " + card3);

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

    public List<Card> containsSet(List<Card> tableCards) {
        List<Card> set = null;

        for (int i = 0; i < tableCards.size(); i++) {
            for (int j = i + 1; j < tableCards.size(); j++) {
                for (int k = j + 1; k < tableCards.size(); k++) {
                    Card card1 = tableCards.get(i);
                    Card card2 = tableCards.get(j);
                    Card card3 = tableCards.get(k);
                    if (isSet(card1, card2, card3)) {
                        set = new ArrayList<>();
                        set.add(card1);
                        set.add(card2);
                        set.add(card3);
                    }
                }
            }
        }

        return set;
    }

}
