import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StationsGraphTest {

    @Test
    void getShortestPath() throws IOException {
        //given
        JsonToLines parseJson = new JsonToLines();

        //when
        HashMap<String, List<Integer>> trainLines = parseJson.getLines();
        HashMap<Integer, List<Integer>> stations = parseJson.getConnectedStations(trainLines);
        StationsGraph graph = new StationsGraph(stations);
        int uticaAve = 135;
        int columbusCircle = 94;
        List<Integer> shortestPath = Arrays.asList(135, 136, 445, 42, 129, 115, 4, 116, 128, 405, 406, 446, 430, 403, 404, 439, 358, 359, 3, 94);

        //then
        assertEquals(shortestPath, graph.getShortestPath(uticaAve,columbusCircle));
    }
}