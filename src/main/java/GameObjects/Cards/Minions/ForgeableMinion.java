package GameObjects.Cards.Minions;

import GameObjects.Cards.CardInterfaces.IForgeable;

public class ForgeableMinion extends Minion implements IForgeable {
    public ForgeableMinion(int x, int y, int width, int height, String file, int manaCost, CardClass classCard) {
        super(x, y, width, height, file, manaCost, classCard);
    }
}
