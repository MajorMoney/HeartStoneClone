package GameObjects.Cards;

import static Utils.ResourceUtils.getFileFromResources;

import GameObjects.Cards.Heros.Hero;
import GameObjects.Cards.Locations.Location;
import GameObjects.Cards.Minions.Minion;
import GameObjects.Cards.Spells.Spell;
import GameObjects.Cards.Weapons.Weapon;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class CardPropertiesImporter {

  // TODO May not be the best option memorywhise
  public HashMap<String, CardProperties> propertiesHasMap;
  private int defaultX, defaultY, defaultWidth, defaultHeight;
  private Gson gson;

  public CardPropertiesImporter(int defaultX, int defaultY, int defaultWidth, int defaultHeight) {
    this.defaultX = defaultX;
    this.defaultY = defaultY;
    this.defaultWidth = defaultWidth;
    this.defaultHeight = defaultHeight;

    GsonBuilder builder = new GsonBuilder();
    builder.setPrettyPrinting();
    gson = builder.create();

    propertiesHasMap = new HashMap<>();

    importCards();
  }

  private void importCards() {
    //            Got a doubt on what would be more performant, ChatGPT convinced me on the
    // implemented version
    //            Since both options will have complexity of O(n) but the copy/remove option has
    // memory overhead for copying the set

    //            Set<String> entrySet = Set.copyOf(jo.keySet());
    //            CardProperties cp = gson.fromJson(jo.remove(entry), CardProperties.class);

    File file = getFileFromResources("CardData/mapTest.json");

    try {
      FileReader reader = new FileReader(file);

      JsonObject jo = gson.fromJson(reader, JsonObject.class);
      Set<String> entrySet = jo.keySet();

      for (String entry : entrySet) {
        CardProperties cp = gson.fromJson(jo.get(entry), CardProperties.class);
        propertiesHasMap.put(entry, cp);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private CardProperties getCardPropertiesById(int id) {
    return propertiesHasMap.get(String.valueOf(id));
  }

  public Card getCard(int id) {
    Card c = createCard(getCardPropertiesById(id));
    System.out.println(c);
    return c;
  }

  public Card createCard(CardProperties cardProperties) {
    switch (cardProperties.getType().toLowerCase()) {
      case "minion":
        return new Minion(defaultX, defaultY, defaultWidth, defaultHeight, cardProperties);
      case "spell":
        return new Spell(defaultX, defaultY, defaultWidth, defaultHeight, cardProperties);
      case "weapon":
        return new Weapon(defaultX, defaultY, defaultWidth, defaultHeight, cardProperties);
      case "location":
        return new Location(defaultX, defaultY, defaultWidth, defaultHeight, cardProperties);
      case "hero":
        return new Hero(defaultX, defaultY, defaultWidth, defaultHeight, cardProperties);
      default:
        throw new NoSuchMethodError(
            "The card type provided doesn't have an existing matching class constructor: "
                + cardProperties.getType());
    }
  }
}
