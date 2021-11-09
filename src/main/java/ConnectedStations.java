import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConnectedStations {

    /**
     * create Hashtable of String(stationId) and list of strings(connected stationsIds)
     * @param trainLines hashtable of all the train lines
     * @return hashtable of stations paired to a list connecting stations
     */
    public HashMap<Integer, List<Integer>> getConnectedStations(HashMap<String, List<Integer>> trainLines) {
        //station(string) to connectedStations list hashtable
        HashMap<Integer, List<Integer>> connectedStations = new HashMap<>();
        for (String lineName : trainLines.keySet()) {
            List<Integer> line = trainLines.get(lineName);
            //each line has at least 1 station, if the first station of that line is not in hashTable, add it
            if (!connectedStations.containsKey(line.get(0))) {
                connectedStations.put(line.get(0), new ArrayList<>());
            }
            //go through all the connectedStations in the line and update the connecting list of each station
            for (int i = 0; i < line.size() - 1; i++) {
                int neighbor1 = line.get(i);
                int neighbor2 = line.get(i + 1);
                // If this station is not in the hash table add it
                if (!connectedStations.containsKey(neighbor2)) {
                    connectedStations.put(neighbor2, new ArrayList<>());
                }
                //if the station at i+1 is not in the connected list of station(i),
                // put i in the neighbor list of i+1 and put i+1 in the neighbor list of i
                if (!connectedStations.get(neighbor1).contains(neighbor2)) {
                    connectedStations.get(neighbor1).add(neighbor2);
                    connectedStations.get(neighbor2).add(neighbor2);
                }
            }
        }
        return connectedStations;
    }

    //for myself for testing
    public static void printConnectedStations(int stationId, HashMap<Integer, List<Integer>> stations) {
        System.out.println(stations.get(stationId));
    }

//    public static void main(String[] args) throws IOException {
//        HashMap<String, List<String>> trainLines = getLines();
////      System.out.println(getLines());
//        HashMap<String, List<String>> stations = getConnectedStations(trainLines);
//        printConnectedStations("328", stations);
//    }
}
