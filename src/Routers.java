import java.util.*;

public class Routers {
  private Vector<Router> routers;

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

}
