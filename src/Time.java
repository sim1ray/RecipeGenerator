public class Time{

  private double prepTime;
  private double cookTime;
  private double startTime;
  private double endTime;

//Pull current time to set start/end times
  public Time(double prepTime, double cookTime){
    this.prepTime = prepTime;
    this.cookTime = cookTime;
  }

  public int getPrepTime(){
    return prepTime;
  }

  public int getCookTime(){
    return time;
  }

  public int getStartTime(){
    return startTime;
  }

  public int getStopTime(){
    return stopTime;
  }

  public void setPrepTime(double prepTime){
    this.prepTime = prepTime;
  }

  //Adjust cook time
  public void setCookTime(double cookTime){
    this.cookTime = cookTime;
  }

  //Set to current time
  private void setStartTime(){
    this.startTime = startTime;
  }

  //Set to start time plus cook time;
  private void setStopTime(double stopTime){
    this.stopTime = stopTime;
  }

  public double getTimeLeft(){
    //Set to current time;
    double currentTime = 0.0;
    return stopTime - currentTime;
  }

}
