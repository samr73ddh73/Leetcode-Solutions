import java.util.*;

/*
Learned 2 new concepts:
1)In Java 8, a Pair<V, K> is added in javafx.util package. The class represent key-value pairs and supports 
very basic operations like getKey(), getValue(), hashCode(), equals(java.lang.Object o).

2.The getOrDefault(Object key, V defaultValue) method of Map interface, implemented by HashMap class is used to get the value mapped with specified 
key. If no value is mapped with the provided key then the default value is returned.
*/


class UndergroundSystem {
    HashMap<String, Pair<Integer, Integer>> checkoutMap = new HashMap<>(); // Route - {TotalTime, Count}
    HashMap<Integer, Pair<String, Integer>> checkInMap = new HashMap<>();  // Uid - {StationName, Time}
    
	public UndergroundSystem() {}
    
	public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }
    
	public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkIn = checkInMap.get(id);
        String route = checkIn.getKey() + "_" + stationName;
        int totalTime = t - checkIn.getValue();
        Pair<Integer, Integer> checkout = checkoutMap.getOrDefault(route, new Pair<>(0, 0));
        checkoutMap.put(route, new Pair<>(checkout.getKey() + totalTime, checkout.getValue() + 1));
    }
    
	public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "_" + endStation;
        Pair<Integer, Integer> checkout = checkoutMap.get(route);
        return (double) checkout.getKey() / checkout.getValue();
    }
}