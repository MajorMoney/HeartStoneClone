package GameObjects.Cards.Minions;

import GameObjects.Cards.CardInterfaces.ITradable;
import GameObjects.Cards.Effects.Effect;
import GameObjects.Cards.Minions.Minion;

public class TradableMinion extends Minion implements ITradable {

    public TradableMinion(int x, int y, int width, int height, String file, int manaCost, CardClass classCard) {
        super(x, y, width, height, file, manaCost, classCard);
    }
}
