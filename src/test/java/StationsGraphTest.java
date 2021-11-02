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
        HashMap<String, List<String>> trainLines = parseJson.getLines();
        HashMap<String, List<String>> stations = parseJson.getConnectedStations(trainLines);
        StationsGraph graph = new StationsGraph(stations);
        String uticaAve = "135";
        String columbusCircle = "94";
        List<String> shortestPath = Arrays.asList("135", "136", "445", "42", "116", "128", "405", "406", "446", "430", "403", "404", "439", "358", "359", "3", "94");

        //then
        assertEquals(shortestPath, graph.getShortestPath(uticaAve,columbusCircle));
    }
}