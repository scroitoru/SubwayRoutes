import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonToStationTest {

    @Test
    void getStations() {
        //given
        JsonToStation parseJson = new JsonToStation();

        //when
        Station station = parseJson.getStations();

        //then
        assertEquals("Astor Pl", station.features.get(0).properties.name);
        assertEquals("http://web.mta.info/nyct/service/", station.features.get(0).properties.url);
        assertEquals("4-6-6 Express", station.features.get(0).properties.line);
        assertEquals("1", station.features.get(0).properties.objectid);
        assertEquals("4 nights, 6-all times, 6 Express-weekdays AM southbound, PM northbound", station.features.get(0).properties.notes);
        assertEquals(-73.99106999861966, station.features.get(0).geometry.coordinates.get(0));
        assertEquals(40.73005400028978, station.features.get(0).geometry.coordinates.get(1));
    }
}