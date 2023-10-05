package GameObjects.Cards.Spells;

import GameObjects.Cards.CardInterfaces.ITradable;
import GameObjects.Cards.CardProperties;

public class TradableSpell extends Spell implements ITradable {

    public TradableSpell(int x, int y, int width, int height, CardProperties cp, int id) {
        super(x, y, width, height, cp);
    }
}
