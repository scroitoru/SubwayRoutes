import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class JsonToLinesTest {

    @Test
    void getLines() throws IOException {
        //given
        JsonToLines parseJson = new JsonToLines();

        //when
        HashMap<String, List<String>> linesToHashMap = parseJson.getLines();

        //then
        assertNotNull(linesToHashMap);
    }


    @Test
    void getConnectedStations() throws IOException{
        //given
        JsonToLines parseJson = new JsonToLines();
        String stationId = "328";

        //when
        HashMap<String, List<String>> linesHashtable = parseJson.getLines();
        HashMap<String, List<String>> connectedStations = parseJson.getConnectedStations(linesHashtable);
        List<String> connections328 = Arrays.asList("372", "330", "345");

        //then
        assertEquals(connections328, connectedStations.get(stationId));
    }
}