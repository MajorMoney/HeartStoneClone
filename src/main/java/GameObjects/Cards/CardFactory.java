package GameObjects.Cards;

import GameObjects.Cards.Minions.Minion;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import netscape.javascript.JSObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class CardFactory {

    private int defaultX,defaultY,defaultWidth,defaultHeight;
    private Gson gson;

    //TODO May not be the best option memorywhise
    private HashMap<String, CardProperties> map;


    public CardFactory(int defaultX,int defaultY,int defaultWidth,int defaultHeight){
        this.defaultX = defaultX;
        this.defaultY =  defaultY;
        this.defaultWidth = defaultWidth;
        this.defaultHeight = defaultHeight;

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        gson = builder.create();

        map = new HashMap<>();

        importCards();
    }

    private void importCards() {
//            Got a doubt on what would be more performant, ChatGPT conviced me on the implemented version
//            Since bith options will have complexity of O(n) but the copy/remove option has memory overhead for copying the set

//            Set<String> entrySet = Set.copyOf(jo.keySet());
//            CardProperties cp = gson.fromJson(jo.remove(entry), CardProperties.class);

        String path = this.getClass().getClassLoader().getResource("CardData/mapTest.json").getPath();

        try {
            FileReader reader = new FileReader(path);

            JsonObject jo =  gson.fromJson(reader, JsonObject.class);
            Set<String> entrySet = jo.keySet();

            for(String entry : entrySet) {
                CardProperties cp = gson.fromJson(jo.get(entry), CardProperties.class);
                map.put(entry,cp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CardProperties getCardPropertiesById(int id) {
        return map.get(String.valueOf(id));
    }


    public Card getCard(int id){
        return new Minion(defaultX,defaultY,defaultWidth,defaultHeight,getCardPropertiesById(id),id);
    }

}
