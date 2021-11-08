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
        HashMap<String, List<Integer>> linesToHashMap = parseJson.getLines();

        //then
        assertNotNull(linesToHashMap);
    }

    @Test
    void getConnectedStations() throws IOException{
        //given
        JsonToLines parseJson = new JsonToLines();
        int stationId = Integer.parseInt("328");

        //when
        HashMap<String, List<Integer>> linesHashtable = parseJson.getLines();
        HashMap<Integer, List<Integer>> connectedStations = parseJson.getConnectedStations(linesHashtable);
        List<Integer> connections328 = Arrays.asList(328, 330, 328, 327);

        //then
        assertEquals(connections328, connectedStations.get(stationId));
    }
}