package GameObjects.Cards.Minions;

import GameObjects.Cards.CardInterfaces.IForgeable;
import GameObjects.Cards.CardProperties;

public class ForgeableMinion extends Minion implements IForgeable {

    public ForgeableMinion(int x, int y, int width, int height, CardProperties cp) {
        super(x, y, width, height, cp);
    }
}
