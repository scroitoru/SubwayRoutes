import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConnectedStationsTest {

    @Test
    void getConnectedStations() throws IOException {
        //given
        ConnectedStations connectedStations = new ConnectedStations();
        JsonToLines parseJson = new JsonToLines();
        int stationId = Integer.parseInt("328");

        //when
        HashMap<String, List<Integer>> linesHashtable = parseJson.getLines();
        HashMap<Integer, List<Integer>> connectedStationsList = connectedStations.getConnectedStations(linesHashtable);
        List<Integer> connections328 = Arrays.asList(327, 330, 345);

        //then
        assertEquals(connections328, connectedStationsList.get(stationId));
    }
}