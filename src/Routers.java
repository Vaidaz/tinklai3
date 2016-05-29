import java.util.*;

public class Routers {
  private Vector<Router> routers;
  private Router from;
  private Router to;

  public Routers(){
    this.routers = new Vector<>();
  }

  public void add(Router router){
    this.routers.addElement(router);
  }

  public Router find(String name){
    for (Router router : this.routers) {
      if (router.getName().equals(name)) {
        return router;
      }
    }

    return null;
  };

  public void initRoutingTables(){
    for (Router router : this.routers) {
      router.initRoutingTable(this.routers);
    }
  }

  public void printRoutingTables(){
    System.out.println("           Routing table");
    for (Router router : this.routers) {
      System.out.print("\t" + router.getName());
    }
    System.out.println();

    for (Router router : this.routers) {
      router.printRoutingTable();
    }
  }

  public void sendPackage(Router from, Router to){
    this.from = from;
    this.to = to;
  }

  public boolean movePackage(){
    System.out.println("Moving package from: " + from.getName());
    this.from.updateRoutingTable();

    Router next = from.getNearestRouter();
    System.out.println("Moving to: " + next.getName());
    this.from = next;

    return from.equals(to);
  }

}
