import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonToStation {
    public Stations getStations(){
        Stations stations = new Stations();
        try{
            //create Gson instance
            Gson gson = new Gson();

            //create reader
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/SubwayStations.json"));

            // convert JSON string to Station object
            stations = gson.fromJson(reader, Stations.class);

            // close reader
            reader.close();

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return stations;
    }
}
