public class TopologyBuilder {

  public static void build(Routers routers) {
    Router a = new Router("A");
    Router b = new Router("B");
    Router c = new Router("C");
    Router d = new Router("D");

    routers.add(a);
    routers.add(b);
    routers.add(c);
    routers.add(d);

    routers.connect(a, b, 10);
    routers.connect(b, c, 8);
    routers.connect(b, d, 7);
    routers.connect(c, d, 9);
    routers.connect(d, a, 12);
  }

}
