package GameObjects.Cards.Weapons;

import GameObjects.Cards.CardInterfaces.ITradable;

public class TradeableWeapon extends Weapon implements ITradable {
    public TradeableWeapon(int x, int y, int width, int height, String file, int manaCost, CardClass classCard) {
        super(x, y, width, height, file, manaCost, classCard);
    }
}
