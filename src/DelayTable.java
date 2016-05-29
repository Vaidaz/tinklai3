class DelayTable {

  private int delay;
  private RoutingTable table;

  public DelayTable(int delay, RoutingTable table){
    this.delay = delay;
    this.table = table;
  }

  public int getDelay(){
    return this.delay;
  }

  public RoutingTable getTable(){
    return this.table;
  }
}
