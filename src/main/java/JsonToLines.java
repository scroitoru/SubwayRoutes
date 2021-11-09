import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class JsonToLines {
    public HashMap<String, List<Integer>> getLines() throws IOException {
        //create Gson instance
        Gson gson = new Gson();

        //create reader
        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/SubwayLines.json"));

        // convert JSON string to Station object
        Lines lines = gson.fromJson(reader, Lines.class);

        //create Hashtable for the trainLines name and the trainLines list containing station ids
        HashMap<String, List<Integer>> allTrainLines = linesToHashMap(lines);

        // close reader
        reader.close();

        return allTrainLines;
    }

    private HashMap<String, List<Integer>> linesToHashMap(Lines lines) {
        HashMap<String, List<Integer>> trainLines = new HashMap<>();
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
}
