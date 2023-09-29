package GameObjects.Cards;

import GameObjects.Cards.Effects.Effect;
import lombok.Data;


@Data
public class CardProperties {

    private Integer attack,health,mana;
    private String name,text,cardClass,set;
    private Effect effect;




}
