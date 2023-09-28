package GameObjects.Cards;

import GameObjects.Cards.Effects.Effect;
import lombok.Data;

@Data
public class CardProperties {

    private int id,attack,health,mana;
    private String text,cardClass,set;
    private Effect effect;

}
