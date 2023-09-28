package GameObjects.Cards;

import GameObjects.Cards.Minions.Minion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class CardFactory {

    private Gson gson;

    public CardFactory(){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        gson = builder.create();
    }

    public CardProperties getCardById(int id) {
        String path = this.getClass().getClassLoader().getResource("CardData/mapTest.json").getPath();

        //TODO pass to HashMap data Structure

        try {
            // Create a FileReader to read the JSON file
            FileReader reader = new FileReader(path);


            //Works as an array for file: test.json
/*
            Type listType = new TypeToken<ArrayList<CardProperties>>(){}.getType();
            ArrayList<CardProperties> list =  gson.fromJson(reader, listType);

            for(CardProperties cp : list){
                System.out.println(cp.toString());
            }
*/

            // Use GSON to parse the JSON into a map where keys are card IDs and values are CardProperties
//            Type type = new TypeToken<Map<String, CardProperties>>(){}.getType();
//
//            Map<String, CardProperties> cardMap = gson.fromJson(reader, type);
//
//            // Convert the ID to a string to match it with the keys in the map
//            String idString = Integer.toString(id);
//
//            // Check if the card with the given ID exists in the map
//            if (cardMap.containsKey(idString)) {
//                // Retrieve and return the card properties
//                return cardMap.get(idString);
//            } else {
//                // Handle the case where the card with the given ID was not found
//                System.out.println("Card with ID " + id + " not found.");
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Return null if an error occurred or the card was not found
    }

    public Card materializeCard(String jsonString){
        CardProperties cp = gson.fromJson(jsonString,CardProperties.class);
        cp.toString();
        return new Minion(1,2,3,4,"random",5, Card.CardClass.DEATH_KNIGHT);
    }

}
