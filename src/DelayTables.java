import java.util.*;

class DelayTables{

  private Vector<DelayTable> tables;

  public DelayTables(){
    this.tables = new Vector<>();
  }

  public void add(DelayTable table){
    this.tables.addElement(table);
  };

  public RoutingTable recalculateRoutingTable(Router router){
    RoutingTable routingtable, correcttable = null;
    int delay;
    Router tmprouter;
    int distance;

    for(DelayTable delaytable : tables){
      routingtable = delaytable.getTable();
      delay = delaytable.getDelay();

      if(correcttable == null){
        correcttable = new RoutingTable();
        for(RouterDistance routerdistance : routingtable.getData()){
          if( routerdistance.getRouter().equals(router) ){
            correcttable.addRow(router, 0);
          } else {
            distance = routerdistance.getDistance();
            tmprouter = routerdistance.getRouter();
            correcttable.addRow(tmprouter, distance + delay);
          }
        }
      } else {
        for(RouterDistance routerdistance : routingtable.getData()){
          distance = routerdistance.getDistance();
          tmprouter = routerdistance.getRouter();
          if(correcttable.getRow(tmprouter).getDistance() > distance + delay){
            correcttable.updateRow(tmprouter, distance + delay);
          }
        }

      }
    }

    return correcttable;
  }
}
