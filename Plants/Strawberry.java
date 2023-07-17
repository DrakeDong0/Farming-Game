/**

The strawberry class represents a specific type of plant called strawberry.
It inherits properties and methods from the Plant class and adds additional functionality specific to strawberry.
*/
//import package
package Plants;
 
import processing.core.PApplet;
import processing.core.PImage;

//strawberry is a child class of Plant
public class Strawberry extends Plant {
  public static int limit = 3; // The maximum growth limit for strawberry plants
  boolean growing = true; // Indicates if the strawberry is currently growing
  boolean watered = false; //Indicates if the crop is watered

  /**
   * 
   * Constructs a new strawberry object.
   * 
   * @param p         The PApplet instance
   * @param x         The x-coordinate of the strawberry
   * @param y         The y-coordinate of the strawberry
   * @param startdate The start date of the strawberry
   */
  public Strawberry(PApplet p, int x, int y, int startdate) {
    //super's the parent class's variables
    super(p, x, y, startdate);
    //sets the strawberry images
    this.image = app.loadImage("PlantPictures/strawberry1.png");
    this.waterimage = app.loadImage("PlantPictures/water.png");
  }

  /**
   * 
   * Returns information about the strawberry plant.
   * 
   * @return A string containing information about the strawberry plant
   */
  public String getInfo() {
    //returns crop data
    String str1 = Integer.toString(startdate);
    return "This crop was grown on day " + str1;
  }

  /**
   * 
   * Checks if the strawberry plant is strawberry
   * 
   * @return true if the strawberry plant is a strawberry, false otherwise
   */
  public boolean cropCheck() {
    return true;
  }
   /**
   * 
   * Checks if the strawberry is mature
   * @return true if the crop is ready to be harvested
   */
  public boolean matureCheck(){
    if (growing == false){
      return true;
    }
    else{
      return false;
      }
  }
 /**
   * 
   * Waters the plant
   * 
   */
  public void water(int daynum){
    watered = true;
  }
  /**
   * 
   * Draws the strawberry plant on the screen.
   */
  public void draw() {
    app.image(image, x, y);
    //draws the water icon if crop isn't watered
    if (watered == false){
      app.image(waterimage,x+10,y+10);
    }
  }
  /**
   * 
   * Harvests the crop
   */
  public void harvest(){
    //harvests the crop if it has stopped growing. Replaces it with a dirt picture
    if (growing == false){
      this.image = app.loadImage("Pictures/dirt.png");
    }
  }
  /**
   * 
   * Grows the strawberry plant based on the given day number.
   * 
   * @param daynum The current day number
   */
  public void grow(int daynum) {
    //daynumx is the number of days the crop has been alive for
    int daynumx = daynum - startdate;
    //number is modded by 5 to get the remainder. This is used to calculate which growth stage it is on
    int n = daynumx % 3;
    //only grows if it is watered and new
    if (growing && watered) {
      //Each case displays a different growth stage image
      if (n == 0) {
        this.image = app.loadImage("PlantPictures/strawberry1.png");
      }
      if (n == 1) {
        this.image = app.loadImage("PlantPictures/strawberry2.png");
      }
      if (n == 2) {
        this.image = app.loadImage("PlantPictures/strawberry3.png");
        growing = false; //stop growing if on final stage
      }
    }
  }

  /**
   * 
   * Returns a string representation of the strawberry plant.
   * 
   * @return A string representation of the strawberry plant
   */
  @Override
  public String toString() {
    String old = super.toString();
    return old + "This plant is a corn";
  }
}