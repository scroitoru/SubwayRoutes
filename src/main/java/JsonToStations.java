import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonToStations {
    public Stations getStations() throws IOException {
            //create Gson instance
            Gson gson = new Gson();

            //create reader
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/SubwayStations.json"));

            // convert JSON string to Station object
            Stations stations = gson.fromJson(reader, Stations.class);

            // close reader
            reader.close();
        return stations;
    }
}
