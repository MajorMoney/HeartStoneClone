package GameObjects.Cards.Spells;

import GameObjects.Cards.CardInterfaces.ITradable;
import GameObjects.Cards.Spells.Spell;

public class TradableSpell extends Spell implements ITradable {
    public TradableSpell(int x, int y, int width, int height, String file, int manaCost, CardClass classCard) {
        super(x, y, width, height, file, manaCost, classCard);
    }
}
