import java.util.List;

public class Station {
    List<Feature> features;

    public static class Feature{
        String type;
        Properties properties;
        Geometry geometry;
    }

    public static class Properties{
        String name;
        String url;
        String line;
        int objectid;
        String notes;
    }

    public static class Geometry{
        String type;
        List<Double> coordinates;
    }
}
