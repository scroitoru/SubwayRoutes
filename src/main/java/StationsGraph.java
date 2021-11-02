import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StationsGraph {
    private final HashMap<String, StationNode> stationNodes;

    /**
     * Constructor creates all stationNodes in the graph
     * @param stations Hashmap
     */
    public StationsGraph(HashMap<String, List<String>> stations) {
        this.stationNodes = new HashMap<>();
        //for each id of the stations hashmap, it creates a stationNode with that id
        //and then puts the id and stationNode in the stationNodes hashMap
        for(String stationId: stations.keySet()){
            stationNodes.put(stationId, new StationNode(stationId));
        }
        //connecting stationNodes to each other
        //for each id in stations, it stores the neighbors of that stationId in a List
        for(String stationId : stations.keySet()){
            List<String> NeighborIds = stations.get(stationId);
            //connects the neighboring nodes to walk over the graph
            //for each neighborId in the NeighborIds list, adds stationNode of that neighborId to the stationNodes list
            for(String neighborId : NeighborIds){
                stationNodes.get(stationId).neighbors.add(stationNodes.get(neighborId));
            }
        }
    }

    public static class StationNode {
        String id;
        boolean visited;
        StationNode parent;
        boolean covered;
        ArrayList<StationNode> neighbors;
        int distance;

        //Constructor
        public StationNode(String id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
            distance = Integer.MAX_VALUE;
        }
    }

    /**
     *
     * @param source startingStation
     * @param destination DestinationStation
     * @return List of the stations that lead to the shortest path starting from source to destination
     */
    public ArrayList<String> getShortestPath(String source, String destination){
        if (!stationNodes.containsKey(source) || !stationNodes.containsKey(destination)){
            throw new IllegalArgumentException("Either source or destination entered, does not exist");
        }
        StationNode sourceStation = stationNodes.get(source);
        StationNode destinationStation = stationNodes.get(destination);
        sourceStation.visited = true;
        sourceStation.distance = 0;
        //list that stores visited stations
        ArrayList<StationNode> visitedList = new ArrayList<>();
        //source is the only visited station for now
        visitedList.add(sourceStation);
        //while there are visited stations that are not covered
        while(!visitedList.isEmpty()){
            //makes the sourceStation coveredStation (coveredStation = shortestDistance)
            StationNode coveredStation = visitedList.get(0);
            //taking the station in the visited list that has the shortest distance to source
            for (int i = 1; i < visitedList.size(); i++){
                //loops through visitedList until find Node with the shortest distance in the visited list and sets it as covered
                if(visitedList.get(i).distance < coveredStation.distance){
                    coveredStation = visitedList.get(i);
                }
            }
            coveredStation.covered = true;
            //once it sets the node as covered it removes it from the visitedList
            visitedList.remove(coveredStation);
            //visits the neighbors of the coveredStation to make the path
            for(StationNode neighbor: coveredStation.neighbors){
                if (!neighbor.covered){
                    if (neighbor.visited){
                        //if the neighbor.distance is the shortest, updates parent and distance
                        if(neighbor.distance > coveredStation.distance + 1){
                            neighbor.parent = coveredStation;
                            neighbor.distance = coveredStation.distance + 1;
                        }
                    }
                    //if node not visited, add neighbor to visitedList, update parent and distance
                    else{
                        neighbor.parent = coveredStation;
                        neighbor.distance = coveredStation.distance + 1;
                        neighbor.visited = true;
                        visitedList.add(neighbor);
                    }
                }
            }
        }
        //if theres's no path between those stations, return null
        if (destinationStation.parent == null){
            return null;
        }
        //list of the shortest path with the stationIds of that path
        ArrayList<String> shortestPath = new ArrayList<>();
        //adds the ids of all the nodes of the path to the shortestPath list
        while(destinationStation != null){
            shortestPath.add(0, destinationStation.id);
            destinationStation = destinationStation.parent;
        }
        return shortestPath;
    }

//    public static void main(String[] args) throws IOException {
//        HashMap<String, List<String>> trainLines = JsonToLines.getLines();
//        HashMap<String, List<String>> stations = JsonToLines.getConnectedStations(trainLines);
//        StationsGraph graph = new StationsGraph(stations);
//        System.out.println(graph.getShortestPath("135", "94"));
//    }
}
