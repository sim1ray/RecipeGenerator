public class Time{

  private double cookTime;
  private double startTime;
  private double endTime;

//Pull current time to set start/end times
  public Time(double cookTime){
    this.cookTime = cookTime;
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

  //Adjust cook time
  public void setCookTime(double cookTime){
    this.cookTime = cookTime;
  }

  //Set to current time
  private void setStartTime(){
  }

  //Set to start time plus cook time;
  private void setStopTime(){
  }

  public double getTimeLeft(){
    //Set to current time;
    double currentTime = 0.0;
    return stopTime - currentTime;
  }

}
