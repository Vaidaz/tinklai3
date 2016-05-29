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

    a.connect(b, 10);
    b.connect(c, 8);
    b.connect(d, 7);
    c.connect(d, 9);
    d.connect(a, 12);

    routers.sendPackage(a, d);
  }

}
