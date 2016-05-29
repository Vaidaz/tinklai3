import java.util.*;

public class Router {

  private String name;
  private Vector<RouterDistance> neighbours;
  private RoutingTable routing_table;

  private static int min_delay = 2;
  private static int max_delay = 3;

  public Router(String name){
    this.name = name;
    this.neighbours = new Vector<>();
    this.routing_table = new RoutingTable();
  }

  public String toString(){
    return "<Router name: " + this.name + ">";
  }

  public String getName(){
    return this.name;
  }

  public void connect(Router router, int distance){
    this.neighbours.addElement(new RouterDistance(router, distance));
    router.getNeighbours().addElement(new RouterDistance(this, distance));
  }

  public void initRoutingTable(Vector<Router> routers){
    routing_table.init(this, routers);
  }

  public void printRoutingTable(){
    System.out.print(this.name + "\t");
    routing_table.print();
    System.out.println();
  }

  public boolean equals(Router compareRouter) {
    String compareName = compareRouter.getName();
    return this.name.equals(compareName);
  }

  public Vector<RouterDistance> getNeighbours(){
    return this.neighbours;
  }

  public void updateRoutingTable(){
    RoutingTable routing_table;
    int delay;
    Random rand = new Random();

    DelayTables delay_tables = new DelayTables();

    for(RouterDistance neighbour : neighbours){
      delay = rand.nextInt((max_delay - min_delay) + 1) + min_delay;
      neighbour.setDistance(delay);

      routing_table = neighbour.getRouter().getRoutingTable();
      delay_tables.add(new DelayTable(delay, routing_table));
      System.out.println("! delay from " + neighbour.getRouter().getName() + " " + delay);
    }

    this.routing_table = delay_tables.recalculateRoutingTable(this);
  }

  public Router getNearestRouter(){
    RouterDistance nearest = null;
    for(RouterDistance neighbour : neighbours){
      if(nearest == null){
        nearest = neighbour;
      } else if ( neighbour.getDistance() < nearest.getDistance() ) {
        nearest = neighbour;
      }
    }

    return nearest.getRouter();
  }

  public RoutingTable getRoutingTable(){
    return this.routing_table;
  }
}
