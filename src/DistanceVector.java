public class DistanceVector {

  public static void main(String[] args) {
    Routers routers = new Routers();

    TopologyBuilder.build(routers);

    String s;
    s = routers.find("B").toString();
    System.out.println(s);
  }

}
