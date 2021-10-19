import java.util.List;

public class Stations {
    List<Feature> features;

    public static class Feature{
        Properties properties;
        Geometry geometry;
    }

    public static class Properties{
        String name;
        String url;
        String line;
        String objectid;
        String notes;
    }

    public static class Geometry{
        List<Double> coordinates;
    }
}
