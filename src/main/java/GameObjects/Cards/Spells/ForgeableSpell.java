package GameObjects.Cards.Spells;

import GameObjects.Cards.CardInterfaces.IForgeable;

public class ForgeableSpell extends Spell implements IForgeable {
    public ForgeableSpell(int x, int y, int width, int height, String file, int manaCost, CardClass classCard) {
        super(x, y, width, height, file, manaCost, classCard);
    }
}
