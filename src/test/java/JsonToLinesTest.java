import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonToLinesTest {

    @Test
    void getLines() throws IOException {
        //given
        JsonToLines parseJson = new JsonToLines();

        //when
        Hashtable<String, List<String>> linesHashtable = parseJson.getLines();

        //then
        assertNotNull(linesHashtable);
    }


//    @Test
//    void getConnectedStations(){
//        //given
//        JsonToLines parseJson = new JsonToLines();
//
//        //when
//        Hashtable<String, List<String>> linesHashtable = parseJson.getLines();
//        Hashtable<String, List<String>> connectedStations = parseJson.getConnectedStations(linesHashtable);
//
//        //then
//        for (String lineName : connectedStations.keySet()){
//            List<String> line = linesHashtable.get(lineName);
//        }
//    }
}