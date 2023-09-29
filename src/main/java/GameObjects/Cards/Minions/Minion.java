package GameObjects.Cards.Minions;

import GameObjects.Cards.Card;
import GameObjects.Cards.CardProperties;
import GameObjects.Cards.ISummonable;
import GameObjects.Cards.Effects.Effect;

public class Minion extends Card implements ISummonable {

    private int attack,health;
    private Effect effect;


    public Minion(int x, int y, int width, int height, CardProperties cp, int id) {
        super(x, y, width, height, cp, id);
        this.attack = cp.getAttack();
        this.health = cp.getHealth();
        this.effect = cp.getEffect();

    }
}
