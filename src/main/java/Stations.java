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

        public double getDistance(double longitude, double latitude){
            double x1 = coordinates.get(0);
            double y1 = coordinates.get(1);
            return Math.sqrt((latitude - y1) * (latitude - y1) + (longitude - x1) * (longitude - x1));
        }
    }

    public Station getClosestStation(double longitude, double latitude){
        Station closestStation = null;
        double minDistance = Integer.MAX_VALUE;
        for (Station currStation : stations){
            double distance = currStation.geometry.getDistance(longitude, latitude);
            if (distance < minDistance){
                closestStation = currStation;
                minDistance = distance;
            }
        }
        return closestStation;
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
