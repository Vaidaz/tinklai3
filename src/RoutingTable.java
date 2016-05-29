import java.util.*;

class RoutingTable {

  private Vector<RouterDistance> routing_table;

  public RoutingTable(){
    routing_table = new Vector<>();
  }

  public void init(Router current_router, Vector<Router> routers){
    // Initializing negative values
    for(Router router : routers){
      addRow(router, -1);
    }

    // Set head to zero
    updateRow(current_router, 0);

    // Setting neighbours distances
    Router router;
    int distance;
    for(RouterDistance neighbour : current_router.getNeighbours()){
      router = neighbour.getRouter();
      distance = neighbour.getDistance();
      updateRow(router, distance);
    }

    getRow(current_router).setIsCalculated(true);


    RouterDistance node;
    Router tmprouter;
    int olddistance;
    // Dijkstra
    while( hasNegativeValues() && hasNotCalculated() ){
      node = minValueAndNotCalculatedRow();
      for(RouterDistance neighbour : node.getRouter().getNeighbours()){
        if( !getRow(neighbour.getRouter()).getIsCalculated() ){
          continue;
        }

        olddistance = getRow(neighbour.getRouter()).getDistance();
        if( olddistance < 0 || olddistance > neighbour.getDistance() ){
          router = neighbour.getRouter();
          distance = neighbour.getDistance();
          updateRow(router, node.getDistance() + distance);
        }
      }
      node.setIsCalculated(true);
    }

  }

  public void print(){
    for(RouterDistance router_distance : this.routing_table){
      System.out.print(router_distance.getDistance() + "\t");
    }
  }

  public void addRow(Router router, int distance){
    this.routing_table.addElement(new RouterDistance(router, distance));
  }

  public void updateRow(Router router, int distance){
    for(RouterDistance router_distance : routing_table){
      if( router_distance.getRouter().equals(router) ){
        router_distance.setDistance(distance);
      }
    }
  }

  public RouterDistance getRow(Router router){
    for(RouterDistance router_distance : routing_table){
      if( router_distance.getRouter().equals(router) ){
        return router_distance;
      }
    }

    return null;
  }

  private boolean hasNegativeValues(){
    for(RouterDistance router_distance : routing_table){
      if( router_distance.getDistance() < 0 ){
        return true;
      }
    }

    return false;
  }

  private boolean hasNotCalculated(){
    for(RouterDistance router_distance : routing_table){
      if( !router_distance.getIsCalculated() ){
        return true;
      }
    }

    return false;
  }

  private RouterDistance minValueAndNotCalculatedRow(){
    RouterDistance routerdistance = null;

    for(RouterDistance router_distance : routing_table){
      if( router_distance.getIsCalculated() ){
        continue;
      }

      if(routerdistance == null ||
          router_distance.getDistance() < routerdistance.getDistance() ){
        routerdistance = router_distance;
      }
    }

    return routerdistance;
  }

  public Vector<RouterDistance> getData(){
    return this.routing_table;
  }
}