package GameObjects.Cards.Minions;

import GameObjects.Cards.Card;
import GameObjects.Cards.ISummonable;
import GameObjects.Cards.Effects.Effect;

public class Minion extends Card implements ISummonable {

    private int attack,health;
    private Effect effect;

    public Minion(int x, int y, int width, int height, String file, int manaCost, CardClass cardClass) {
        super(x, y, width, height, file, manaCost, cardClass);
        this.attack = attack;
        this.health = health;
        this.effect = effect;

    }

}
