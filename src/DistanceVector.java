public class DistanceVector {

  public static void main(String[] args) {
    System.out.println("Paspauskite Enter norėdami pereiti į kita žingsnį. Paspauskite q norėdami baigti\n");

    Routers routers = new Routers();
    TopologyBuilder.build(routers);

    routers.initRoutingTables();

    boolean run = true;
    int iteration = 0;
    while(run){
      System.out.println("\n***************** Iteracija nr." + iteration + " *****************\n");

      if(iteration != 0){
        run = !routers.movePackage();
        System.out.println();
      }

      routers.printRoutingTables();

      String input = System.console().readLine();

      if( input.equals("q") ){
        run = false;
      }


      iteration++;
    }

  }

}
