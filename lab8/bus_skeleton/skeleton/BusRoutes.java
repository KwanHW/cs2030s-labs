import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * Encapsulates the result of a query: for a bus stop and a search string,
 * it stores a map of bus services that servce stops with matching name.
 * e.g., stop 12345, name "MRT", with map contains:
 *    96: 11223 "Clementi MRT"
 *    95:  22334 "Beuno Vista MRT"
 *
 * @author: Ooi Wei Tsang
 * @version: CS2030 AY19/20 Semester 1, Lab 10
 */
class BusRoutes {
  final BusStop stop;
  final String name;
  final Map<BusService,CompletableFuture<Set<BusStop>>> services;

  /**
   * Constructor for creating a bus route.
   * @param stop The first bus stop.
   * @param name The second bus stop.
   * @param services The set of bus services between the two stops.
   */
  BusRoutes(BusStop stop, String name, Map<BusService,CompletableFuture<Set<BusStop>>> services) {
    this.stop = stop;
    this.name = name;
    this.services = services;
  }

  /**
   * Return a string describing the bus route.
   * @return The first line contains the query information:
   *     bus stop id and search string.  The remaining line contains 
   *     the bus services and matching stops served.
   */
  public CompletableFuture<String> description() {
    String res = "Search for: " + this.stop + " <-> " + name + ":\n";
    res += "From " +  this.stop + "\n";

    CompletableFuture<String> result = CompletableFuture.completedFuture(res);

    // Goes through every BusService
    for (BusService service: services.keySet()) {
        // Gets the stops that the BusService goes to
        CompletableFuture<Set<BusStop>> stops = services.get(service);
        
        // Appends message from describeService to the overall message
        result = result.thenCombine(this.describeService(service,stops),(x,y)->x+y);
    }
    
    return result;
  }

  /**
   * Return a string representation a bus service and its matching stops.
   * @return The first line contains the query information:
   *     bus stop id and search string.  The remaining line contains 
   *     the bus services and matching stops served.
   */
  public CompletableFuture<String> describeService(BusService service, CompletableFuture<Set<BusStop>> stops) {
      return stops.thenApply(stop -> {
          if (stop.isEmpty()) {
              return "";
          }

          return stop.stream()
              .filter(s -> s != this.stop) 
              .reduce("- Can take " + service + " to:\n",
                      (str, s) -> str += "  - " + s + "\n",
                      (str1, str2) -> str1 + str2);
      });
  }
}
