class RouterDistance {

  private Router router;
  private int distance;
  private boolean is_calculated;

  public RouterDistance(Router router, int distance){
    this.router = router;
    this.distance = distance;
    this.is_calculated = false;
  }

  public int getDistance(){
    return this.distance;
  }

  public Router getRouter(){
    return this.router;
  }

  public void setDistance(int distance){
    this.distance = distance;
  }

  public boolean getIsCalculated(){
    return this.is_calculated;
  }

  public void setIsCalculated(boolean is_calculated){
    this.is_calculated = is_calculated;
  }
}
