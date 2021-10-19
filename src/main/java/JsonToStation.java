import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonToStation {
    public Station getStations(){
        Station station = new Station();
        try{
            //create Gson instance
            Gson gson = new Gson();

            //create reader
            Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));

            // convert JSON string to Station object
            station = gson.fromJson(reader,Station.class);

            // close reader
            reader.close();

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return station;
    }
}
