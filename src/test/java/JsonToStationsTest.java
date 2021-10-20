import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonToStationsTest {

    @Test
    void getStations() throws IOException {
        //given
        JsonToStations parseJson = new JsonToStations();

        //when
        Stations stations = parseJson.getStations();

        //then
        assertEquals("Astor Pl", stations.features.get(0).properties.name);
        assertEquals("http://web.mta.info/nyct/service/", stations.features.get(0).properties.url);
        assertEquals("4-6-6 Express", stations.features.get(0).properties.line);
        assertEquals("1", stations.features.get(0).properties.objectid);
        assertEquals("4 nights, 6-all times, 6 Express-weekdays AM southbound, PM northbound", stations.features.get(0).properties.notes);
        assertEquals(-73.99106999861966, stations.features.get(0).geometry.coordinates.get(0));
        assertEquals(40.73005400028978, stations.features.get(0).geometry.coordinates.get(1));
    }
}