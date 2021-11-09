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
}