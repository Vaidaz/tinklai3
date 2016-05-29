public class Router {

  private String name;

  public Router(String name){
    this.name = name;
  }

  public String toString(){
    return "<Router name: " + this.name + ">";
  }

  public String getName(){
    return this.name;
  }

}
