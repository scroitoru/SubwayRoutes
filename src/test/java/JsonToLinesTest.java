import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

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

        //then
        assertEquals("[327, 330, 345]", connectedStations.get(stationId));



        //        for (String neighborId : connectedStations.get(stationId)){
//            assertEquals("[327, 330, 345]", connectedStations.get(neighborId));
//        }
    }
}