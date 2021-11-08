import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;

public class Stations {
    @SerializedName("features")
    List<Station> stations;

    public static class Station {
        Properties properties;
        Geometry geometry;
    }

    public static class Properties {
        String name;
        int objectid;
        String url;
        String line;
        String notes;
    }

    public static class Geometry {
        List<Double> coordinates;
    }

    /**
     *
     * @return HashMap of all station ids mapped to the stations
     */
    public HashMap<Integer, Station> getStations(){
        HashMap<Integer, Station> allStations = new HashMap<>();
        for (Station station : this.stations){
            allStations.put(station.properties.objectid, station);
        }
        return allStations;
    }
}
