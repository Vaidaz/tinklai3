public class TopologyBuilder {

  public static void build(Routers routers) {
    routers.add(new Router("A"));
    routers.add(new Router("B"));
    routers.add(new Router("C"));
  }

}
