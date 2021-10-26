import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonToLines {
    public SubwayLines getLines() throws IOException {
        //create Gson instance
        Gson gson = new Gson();

        //create reader
        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/SubwayLines.json"));

        // convert JSON string to Station object
        SubwayLines lines = gson.fromJson(reader, SubwayLines.class);

        // close reader
        reader.close();
        return lines;
    }
}
