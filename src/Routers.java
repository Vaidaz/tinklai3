import java.util.*;

public class Routers {
  private Vector<Router> routers;
  private Vector<Connection> connections;

  public Routers(){
    this.routers = new Vector<>();
    this.connections = new Vector<>();
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

  public void connect(Router router1, Router router2, int distance){
    this.connections.addElement(new Connection(router1, router2, distance));
  }

}
