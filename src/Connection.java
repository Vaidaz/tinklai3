public class Connection{

  private Router router1;
  private Router router2;
  private int distance;

  public Connection(Router router1, Router router2, int distance){
    this.router1 = router1;
    this.router2 = router2;
    this.distance = distance;
  }

  public int getDistance(){
    return this.distance;
  }

  public String getRouter1Name(){
    return this.router1.getName();
  }

  public String getRouter2Name(){
    return this.router2.getName();
  }

  public boolean isConnectedWith(Router router){
    return this.router1.equals(router) || this.router2.equals(router);
  }

}
