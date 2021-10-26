import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class JsonToLines {
    public Hashtable<String, List<String>> getLines() throws IOException {
        //create Gson instance
        Gson gson = new Gson();

        //create reader
        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/SubwayLines.json"));

        // convert JSON string to Station object
        Lines lines = gson.fromJson(reader, Lines.class);

        //create Hashtable for the trainLines name and the trainLines list containing station ids
        Hashtable<String, List<String>> allTrainLines = linesToHashtable(lines);

        // close reader
        reader.close();

        return allTrainLines;
    }

    /**
     * create Hashtable of String(stationId) and list of strings(connected stationsIds)
     * @param trainLines hashtable of all the train lines
     * @return hashtable of stations paired to a list connecting stations
     */
    public Hashtable<String, List<String>> getConnectedStations(Hashtable<String, List<String>> trainLines) {
        //station(string) to connectedStations list hashtable
        Hashtable<String, List<String>> connectedStations = new Hashtable<>();
        for (String lineName : trainLines.keySet()) {
            List<String> line = trainLines.get(lineName);
            //each line has at least 1 station, if the first station of that line is not in hashTable, add it
            if (!connectedStations.containsKey(line.get(0))) {
                connectedStations.put(line.get(0), new ArrayList<String>());
            }
            //go through all the connectedStations in the line and update the connecting list of each station
            for (int i = 0; i < line.size() - 1; i++) {
                // If this station is not in the hash table add it
                if (!connectedStations.containsKey(line.get(i + 1))) {
                    connectedStations.put(line.get(i + 1), new ArrayList<String>());
                }
                //if the station at i+1 is not in the connected list of station(i),
                // put i in the neighbor list of i+1 and put i+1 in the neighbor list of i
                if (!connectedStations.get(line.get(i)).contains(line.get(i + 1))) {
                    connectedStations.get(line.get(i)).add(line.get(i + 1));
                    connectedStations.get(line.get(i + 1)).add(line.get(i));
                }
            }
        }
        return connectedStations;
    }

    private Hashtable<String, List<String>> linesToHashtable(Lines lines) {
        Hashtable<String, List<String>> trainLines = new Hashtable<String, List<String>>();
        //add the lines to the hashtable
        trainLines.put("A", lines.A);
        trainLines.put("B", lines.B);
        trainLines.put("C", lines.C);
        trainLines.put("D", lines.D);
        trainLines.put("E", lines.E);
        trainLines.put("F", lines.F);
        trainLines.put("G", lines.G);
        trainLines.put("J", lines.J);
        trainLines.put("L", lines.L);
        trainLines.put("M", lines.M);
        trainLines.put("N", lines.N);
        trainLines.put("Q", lines.Q);
        trainLines.put("R", lines.R);
        trainLines.put("S", lines.S);
        trainLines.put("W", lines.W);
        trainLines.put("Z", lines.Z);
        trainLines.put("_7Express", lines._7Express);
        trainLines.put("_6Express", lines._6Express);
        trainLines.put("_1", lines._1);
        trainLines.put("_2", lines._2);
        trainLines.put("_3", lines._3);
        trainLines.put("_4", lines._4);
        trainLines.put("_5", lines._5);
        trainLines.put("_6", lines._6);
        trainLines.put("_7", lines._7);

        return trainLines;
    }


    //for myself for testing
    public void printConnectedStations(String stationId, Hashtable<String, List<String>> stations) {
        System.out.println(stations.get(stationId));
    }

//    public static void main(String[] args) throws IOException {
//        Hashtable<String, List<String>> trainLines = getLines();
//        System.out.println(getLines());
//        Hashtable<String, List<String>> stations = getConnectedStations(trainLines);
//        printConnectedStations("16", stations);
//    }
}
